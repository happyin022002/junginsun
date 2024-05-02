/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ScqAwkwardDBDAOaddPriScqAwkMnTmpCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.23
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2015.04.23 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHojin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqAwkwardDBDAOaddPriScqAwkMnTmpCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SCQ_AWK_MN_TMP 테이블 생성
	  * * 2015.04.23 송호진 [CHM-201533702] SCQ내에 Unit Dual (cm/Inch) System 개발 요청
	  * </pre>
	  */
	public ScqAwkwardDBDAOaddPriScqAwkMnTmpCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_ver_no_tmp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("scq_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration").append("\n"); 
		query.append("FileName : ScqAwkwardDBDAOaddPriScqAwkMnTmpCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SCQ_AWK_MN_TMP" ).append("\n"); 
		query.append("	( SCQ_RQST_NO                      " ).append("\n"); 
		query.append("	, SCQ_VER_NO                       " ).append("\n"); 
		query.append("	, CRE_USR_ID                       " ).append("\n"); 
		query.append("	, CRE_DT                           " ).append("\n"); 
		query.append("	, UPD_USR_ID                       " ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append("    , MEAS_SYS_CD" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	VALUES" ).append("\n"); 
		query.append("	( @[scq_rqst_no]                " ).append("\n"); 
		query.append("	, @[scq_ver_no_tmp]                     " ).append("\n"); 
		query.append("	, @[cre_usr_id]                     " ).append("\n"); 
		query.append("	, SYSDATE                     " ).append("\n"); 
		query.append("	, @[cre_usr_id]                     " ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("    , NVL ( @[meas_sys_cd], 'M' )" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}