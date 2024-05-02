/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOmodifyConfirmIndCUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.04
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.12.04 김승민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEUN GMIN KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsManifestListDownloadDBDAOmodifyConfirmIndCUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROCS(ROTTERDAM) 세관에 신고할 대상 Manifest List를 전송하기 전에 데이터를 확인했다는 의미로 Confirm Indicator를 업데이트 하는데
	  * Container 정보 미존재시(searchCntrForCfm 실행결과가 없는 경우) 'C'로 업데이트한다.
	  * - modifyConfirmIndD 오퍼레이션 실행 조건(Full Cargo이면서 Cargo Description 정보 미존재)에 해당하여 이미 'D'로 업데이트 되어 있는 경우에도
	  *    Container 정보 미존재시 'C'로 다시 업데이트 한다.
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOmodifyConfirmIndCUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_crn_number",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_dat_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOmodifyConfirmIndCUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_RTM_BL" ).append("\n"); 
		query.append("SET    CSTMS_DAT_CFM_CD = 'C', CSTMS_DECL_USR_ID = @[user_id]," ).append("\n"); 
		query.append("BL_DAT_CFM_DT = to_date(@[bl_dat_cfm_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("WHERE  VSL_CALL_REF_NO = @[frm_crn_number]" ).append("\n"); 
		query.append("AND    BKG_NO =  @[bkg_no]" ).append("\n"); 

	}
}