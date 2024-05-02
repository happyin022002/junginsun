/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOModifyBkgVgmWgtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOModifyBkgVgmWgtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLDocumentationCMDBDAOModifyBkgVgmWgt
	  * </pre>
	  */
	public BLDocumentationCMDBDAOModifyBkgVgmWgtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vgm_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_tp",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wgt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_vgm_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xter_vgm_doc_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOModifyBkgVgmWgtUSQL").append("\n"); 
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
		query.append("SET  VGM_WGT = DECODE(@[wgt_tp_cd],'V',ROUND(DECODE(@[vgm_wgt_ut_cd],'KGS',@[vgm_wgt],'LBS',@[vgm_wgt]*0.453592,NULL),3)" ).append("\n"); 
		query.append("								  ,'C',ROUND(DECODE(@[vgm_wgt_ut_cd],'KGS',@[vgm_wgt],'LBS',@[vgm_wgt]*0.453592,NULL),3)+MST_SPEC_FNC('TARE', @[cntr_no]))" ).append("\n"); 
		query.append("    ,VGM_WGT_UT_CD = 'KGS'" ).append("\n"); 
		query.append("    --,VGM_WGT_UPD_DT = SYSDATE" ).append("\n"); 
		query.append("	,VGM_WGT_UPD_DT = NVL((SELECT GLOBALDATE_PKG.TIME_LOCAL_FNC(MDM.LOC_CD) " ).append("\n"); 
		query.append("						FROM BKG_XTER_USR_INFO USR, MDM_CUSTOMER MDM" ).append("\n"); 
		query.append("						WHERE USR.USR_ID = @[usr_id]" ).append("\n"); 
		query.append("						  AND MDM.CUST_CNT_CD = USR.CUST_CNT_CD" ).append("\n"); 
		query.append("						  AND MDM.CUST_SEQ = USR.CUST_SEQ" ).append("\n"); 
		query.append("						),GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(),sysdate,'SGSIN'))" ).append("\n"); 
		query.append("    ,VGM_WGT_UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("	,WGT_TP_CD = @[wgt_tp_cd]" ).append("\n"); 
		query.append("	,XTER_SNDR_ID = DECODE(@[vgm_tp],'ENC','WEB',@[xter_sndr_id])" ).append("\n"); 
		query.append("	,XTER_VGM_DOC_ID = DECODE(@[vgm_tp],'ENC',@[bkg_no],@[xter_vgm_doc_id])" ).append("\n"); 
		query.append("	,XTER_VGM_RQST_SEQ = DECODE(@[vgm_tp],'ENC',@[vgm_seq],@[xter_vgm_rqst_seq])" ).append("\n"); 
		query.append("	,XTER_VGM_USR_ID = DECODE(@[vgm_tp],'ENC',@[usr_id],'')" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}