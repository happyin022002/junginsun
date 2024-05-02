/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOcheckOfficeCodeDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.10.28 권영법
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 권영법
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOcheckOfficeCodeDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 벨리데이션을 체크하기 위해 데이타를 조회한다.
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOcheckOfficeCodeDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("check_hq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("check_value",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOcheckOfficeCodeDataRSQL").append("\n"); 
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
		query.append("SELECT A.OFC_CD AS CD_ID,A.OFC_ENG_NM AS CD_DESC" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.OFC_CD = @[check_value]" ).append("\n"); 
		query.append("#if (${check_hq} != '')" ).append("\n"); 
		query.append("AND A.AR_HD_QTR_OFC_CD = @[check_hq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_knd_cd} == '2')" ).append("\n"); 
		query.append("AND A.OFC_KND_CD =  @[ofc_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_knd_cd} != '2')" ).append("\n"); 
		query.append("AND A.OFC_KND_CD <>  @[ofc_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}