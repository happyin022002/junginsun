/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SriLankaManifestListDownloadDBDAOsearchResponseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.08.19 임재택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LIM JAE TAEK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SriLankaManifestListDownloadDBDAOsearchResponseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 스리랑카세관으로 부터 수신된 응답문서 내용을 조회한다.
	  * </pre>
	  */
	public SriLankaManifestListDownloadDBDAOsearchResponseRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lk_cstms_rspn_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration").append("\n"); 
		query.append("FileName : SriLankaManifestListDownloadDBDAOsearchResponseRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(SR_STS_CD,'1','Received Successfully','Rejected') SR_STS_CD," ).append("\n"); 
		query.append("NVL(TO_CHAR(RGST_DT,'YYYY-MM-DD HH24:MI:SS'),' ') RGST_DT ," ).append("\n"); 
		query.append("NVL(TO_CHAR(RJCT_DT,'YYYY-MM-DD HH24:MI:SS'),' ') RJCT_DT," ).append("\n"); 
		query.append("VSL_AUTH_NO, SR_STS_DESC, SR_CMT_DESC, decode(DECL_BL_QTY,null,'',0,'',DECL_BL_QTY) DECL_BL_QTY" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_SRI_RCV_LOG" ).append("\n"); 
		query.append("WHERE   VSL_NM     = @[vsl_nm]" ).append("\n"); 
		query.append("AND     SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND     SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND     LK_CSTMS_RSPN_DIV_CD = @[lk_cstms_rspn_div_cd]" ).append("\n"); 
		query.append("AND     SR_STS_CD = @[sr_sts_cd]" ).append("\n"); 

	}
}