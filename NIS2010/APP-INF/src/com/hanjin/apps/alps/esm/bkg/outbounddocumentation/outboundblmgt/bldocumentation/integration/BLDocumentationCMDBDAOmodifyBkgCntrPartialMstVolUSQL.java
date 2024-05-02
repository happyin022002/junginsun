/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BLDocumentationCMDBDAOmodifyBkgCntrPartialMstVolUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOmodifyBkgCntrPartialMstVolUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * split 시 source bkg의 volume, weight를 update한다
	  * </pre>
	  */
	public BLDocumentationCMDBDAOmodifyBkgCntrPartialMstVolUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOmodifyBkgCntrPartialMstVolUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CONTAINER" ).append("\n"); 
		query.append("   SET CNTR_PRT_FLG = 'Y'" ).append("\n"); 
		query.append("	 , CNTR_VOL_QTY = TO_NUMBER(@[cntr_vol_qty]) - NVL((SELECT SUM(CNTR_VOL_QTY) " ).append("\n"); 
		query.append("														FROM BKG_BOOKING BK, BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("													   WHERE BK.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("														 AND BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("														 AND BK.BKG_CRE_TP_CD = 'S'" ).append("\n"); 
		query.append("														 AND BK.FM_BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("														 AND CNTR.CNTR_NO = @[cntr_no]), 0)" ).append("\n"); 
		query.append("     , CNTR_WGT = TO_NUMBER(@[cntr_wgt]) - NVL((SELECT SUM(CNTR_WGT) " ).append("\n"); 
		query.append("												FROM BKG_BOOKING BK, BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("											   WHERE BK.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("												 AND BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("												 AND BK.BKG_CRE_TP_CD = 'S'" ).append("\n"); 
		query.append("												 AND BK.FM_BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("												 AND CNTR.CNTR_NO = @[cntr_no]), 0)" ).append("\n"); 
		query.append("     , UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("	 , UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}