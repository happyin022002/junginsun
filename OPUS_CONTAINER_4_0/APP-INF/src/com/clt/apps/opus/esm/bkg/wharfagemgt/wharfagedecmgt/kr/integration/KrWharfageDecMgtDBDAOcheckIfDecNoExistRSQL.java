/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOcheckIfDecNoExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.11.11 정재엽
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Jae Yoeb
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOcheckIfDecNoExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOcheckIfDecNoExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOcheckIfDecNoExistRSQL").append("\n"); 
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
		query.append("SELECT COUNT(VSL_CD) AS CNT" ).append("\n"); 
		query.append("FROM BKG_KR_WHF_RT A" ).append("\n"); 
		query.append("WHERE A.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND A.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("AND WHF_BND_CD = @[whf_bnd_cd]" ).append("\n"); 
		query.append("AND WHF_DECL_NO IS NOT NULL" ).append("\n"); 
		query.append("AND ROWNUM <= 1" ).append("\n"); 

	}
}