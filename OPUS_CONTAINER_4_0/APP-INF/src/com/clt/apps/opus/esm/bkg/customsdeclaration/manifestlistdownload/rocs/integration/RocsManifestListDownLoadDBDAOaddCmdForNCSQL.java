/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RocsManifestListDownLoadDBDAOaddCmdForNCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.09
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.05.09 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsManifestListDownLoadDBDAOaddCmdForNCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CMD Info 생성
	  * </pre>
	  */
	public RocsManifestListDownLoadDBDAOaddCmdForNCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crn_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownLoadDBDAOaddCmdForNCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_RTM_CGO_MF" ).append("\n"); 
		query.append("         	(VSL_CALL_REF_NO,       BKG_NO,       CNTR_NO," ).append("\n"); 
		query.append("          	CNTR_MF_SEQ,      CNTR_MF_MK_DESC,  CNTR_MF_DESC," ).append("\n"); 
		query.append("          	PCK_TP_CD,   PCK_QTY,   PCK_DESC," ).append("\n"); 
		query.append("          	CNTR_WGT_UT_CD,   CNTR_MF_WGT,   CMDT_MEAS_UT_CD,       CNTR_MF_MEAS_QTY," ).append("\n"); 
		query.append("          	CRE_USR_ID,  CRE_OFC_CD, UPD_USR_ID,   UPD_DT,        CRE_DT,    EDI_SEQ," ).append("\n"); 
		query.append("				HAMO_TRF_CD)" ).append("\n"); 
		query.append("         		SELECT @[crn_number],BKG_NO, CNTR_NO," ).append("\n"); 
		query.append("           	     CM.CNTR_MF_SEQ,            CNTR_MF_MK_DESC,         CNTR_MF_GDS_DESC," ).append("\n"); 
		query.append("           	     CM.PCK_TP_CD,             NVL(PCK_QTY,0),      PKG.PCK_NM," ).append("\n"); 
		query.append("           	     WGT_UT_CD,            NVL(CNTR_MF_WGT,0),      MEAS_UT_CD,       NVL(MEAS_QTY,0)," ).append("\n"); 
		query.append("           	     @[user_id],    @[ofc_cd], @[user_id],   sysdate,       sysdate,           rownum," ).append("\n"); 
		query.append("					  CMDT_HS_CD" ).append("\n"); 
		query.append("         	FROM BKG_CNTR_MF_DESC CM, MDM_PCK_TP PKG" ).append("\n"); 
		query.append("         	WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         	AND CM.PCK_TP_CD = PKG.PCK_CD" ).append("\n"); 

	}
}