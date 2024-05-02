/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOCheckBkgQtyDtlSplitRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.06.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOCheckBkgQtyDtlSplitRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckBkgQtyDtlSplit
	  * 2011.06.08 이일민 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOCheckBkgQtyDtlSplitRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOCheckBkgQtyDtlSplitRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT CASE WHEN (ROW_CNT = DRY_CGO_CNT " ).append("\n"); 
		query.append("                  AND DRY_CGO_CNT > 0" ).append("\n"); 
		query.append("                  AND SPC_CGO_CNT = 0" ).append("\n"); 
		query.append("                  AND EQ_SUBST_CGO_QTY = 0 ) THEN 'Y'" ).append("\n"); 
		query.append("        ELSE 'N' END AS SPLIT_FLG" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("    SELECT ROW_CNT," ).append("\n"); 
		query.append("           DRY_CGO_CNT," ).append("\n"); 
		query.append("           SPC_CGO_CNT," ).append("\n"); 
		query.append("           ( SELECT " ).append("\n"); 
		query.append("             SUM( NVL(EQ_SUBST_CGO_QTY,0) )  " ).append("\n"); 
		query.append("             FROM BKG_QUANTITY" ).append("\n"); 
		query.append("             WHERE BKG_NO=@[bkg_no]) EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("     FROM(" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                   MAX(ROWNUM) ROW_CNT," ).append("\n"); 
		query.append("                   SUM( DECODE(NVL(DRY_CGO_FLG,'N'),'Y',1,0) ) AS DRY_CGO_CNT," ).append("\n"); 
		query.append("                   ( SUM( DECODE(NVL(AWK_CGO_FLG,'N'),'Y',1,0) )" ).append("\n"); 
		query.append("                   + SUM( DECODE(NVL(DCGO_FLG,'N'),'Y',1,0) )" ).append("\n"); 
		query.append("                   + SUM( DECODE(NVL(RC_FLG,'N'),'Y',1,0) )" ).append("\n"); 
		query.append("                   + SUM( DECODE(NVL(BB_CGO_FLG,'N'),'Y',1,0) )" ).append("\n"); 
		query.append("                   + SUM( DECODE(NVL(SOC_FLG,'N'),'Y',1,0) )" ).append("\n"); 
		query.append("                   + SUM( DECODE(NVL(MER_HNGR_FLG,'N'),'Y',1,0) )" ).append("\n"); 
		query.append("                   + SUM( DECODE(NVL(CRR_HNGR_FLG,'N'),'Y',1,0) )" ).append("\n"); 
		query.append("                   + SUM( DECODE(NVL(CRR_HNGR_SGL_BAR_USE_FLG,'N'),'Y',1,0))" ).append("\n"); 
		query.append("                   + SUM( DECODE(NVL(CRR_HNGR_DBL_BAR_USE_FLG,'N'),'Y',1,0))" ).append("\n"); 
		query.append("                   + SUM( DECODE(NVL(CRR_HNGR_TPL_BAR_USE_FLG,'N'),'Y',1,0)) ) AS SPC_CGO_CNT" ).append("\n"); 
		query.append("            FROM BKG_QTY_DTL A" ).append("\n"); 
		query.append("            WHERE BKG_NO=@[bkg_no]" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}