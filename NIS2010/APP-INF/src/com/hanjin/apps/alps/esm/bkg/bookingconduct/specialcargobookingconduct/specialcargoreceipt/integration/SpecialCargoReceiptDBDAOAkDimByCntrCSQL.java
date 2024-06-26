/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOAkDimByCntrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.18
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2012.04.18 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOAkDimByCntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOAkDimByCntrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tgt_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOAkDimByCntrCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_AWK_DIM" ).append("\n"); 
		query.append("            (BKG_NO" ).append("\n"); 
		query.append(",            AWK_CGO_SEQ" ).append("\n"); 
		query.append(",            DIM_SEQ" ).append("\n"); 
		query.append(",            DIM_LEN" ).append("\n"); 
		query.append(",            DIM_WDT" ).append("\n"); 
		query.append(",            DIM_HGT" ).append("\n"); 
		query.append(",			 INDIV_PCK_WGT" ).append("\n"); 
		query.append(",            CRE_USR_ID" ).append("\n"); 
		query.append(",            CRE_DT" ).append("\n"); 
		query.append(",            UPD_USR_ID" ).append("\n"); 
		query.append(",            UPD_DT" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    SELECT @[tgt_bkg_no]" ).append("\n"); 
		query.append(",          (SELECT NVL(MAX(AWK_CGO_SEQ), 0)" ).append("\n"); 
		query.append("              FROM BKG_AWK_DIM" ).append("\n"); 
		query.append("             WHERE BKG_NO = @[tgt_bkg_no]) + 1" ).append("\n"); 
		query.append(",          DIM_SEQ" ).append("\n"); 
		query.append(",          DIM_LEN" ).append("\n"); 
		query.append(",          DIM_WDT" ).append("\n"); 
		query.append(",          DIM_HGT" ).append("\n"); 
		query.append(",		   INDIV_PCK_WGT" ).append("\n"); 
		query.append(",          @[cre_usr_id]" ).append("\n"); 
		query.append(",          SYSDATE" ).append("\n"); 
		query.append(",          @[cre_usr_id]" ).append("\n"); 
		query.append(",          SYSDATE" ).append("\n"); 
		query.append("    FROM   BKG_AWK_DIM" ).append("\n"); 
		query.append("    WHERE  BKG_NO = @[src_bkg_no]" ).append("\n"); 
		query.append("    AND    AWK_CGO_SEQ IN (SELECT AWK_CGO_SEQ FROM   BKG_AWK_CGO" ).append("\n"); 
		query.append("                           WHERE  BKG_NO = @[src_bkg_no]" ).append("\n"); 
		query.append("                           AND    CNTR_NO = @[cntr_no])" ).append("\n"); 

	}
}