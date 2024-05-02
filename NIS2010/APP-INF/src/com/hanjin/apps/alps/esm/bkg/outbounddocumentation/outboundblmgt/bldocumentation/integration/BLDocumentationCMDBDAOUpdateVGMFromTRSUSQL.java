/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BLDocumentationCMDBDAOUpdateVGMFromTRSUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
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

public class BLDocumentationCMDBDAOUpdateVGMFromTRSUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS --> BKG 로 VGM 업데이트
	  * </pre>
	  */
	public BLDocumentationCMDBDAOUpdateVGMFromTRSUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vgm_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOUpdateVGMFromTRSUSQL").append("\n"); 
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
		query.append("SET  VGM_WGT           = (CASE WHEN NVL(VGM_WGT,0) = 0 THEN TO_NUMBER(@[vgm_wgt]) ELSE VGM_WGT END) " ).append("\n"); 
		query.append("    ,VGM_WGT_UT_CD     = (CASE WHEN NVL(VGM_WGT,0) = 0 THEN DECODE(@[vgm_wgt_ut_cd], 'KGM', 'KGS','LBR','LBS', @[vgm_wgt_ut_cd]) ELSE VGM_WGT_UT_CD END)" ).append("\n"); 
		query.append("    ,VGM_VRFY_SIG_CTNT = (CASE WHEN NVL(VGM_WGT,0) = 0 THEN 'SML on behalf of Shipper' ELSE VGM_VRFY_SIG_CTNT END)" ).append("\n"); 
		query.append("    ,UPD_USR_ID        = (CASE WHEN NVL(VGM_WGT,0) = 0 THEN @[upd_usr_id] ELSE UPD_USR_ID END)" ).append("\n"); 
		query.append("    ,UPD_DT            = (CASE WHEN NVL(VGM_WGT,0) = 0 THEN SYSDATE ELSE UPD_DT END)" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}