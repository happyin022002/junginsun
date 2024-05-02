/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCProposalMainDBDAOPriSpHdrPreFixChkVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.11.17 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPriSpHdrPreFixChkVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 이전
	  * 사용자의 off_cd 로
	  * mdm_organization 검색 하여 loc_cd를 찾고
	  * loc_cd로 mdm_location을 검색하여 sconti_cd를 찾는다.
	  * 찾은 sconti_cd로 PRI_SC_PFX_MAPG 의 sconti_cd와 
	  * scope_cd로 join하여 pre_fix를 가져온다.
	  * SELECT SVC_SCP_CD
	  * FROM   PRI_SC_PFX_MAPG
	  * WHERE  SCONTI_CD = (SELECT SCONTI_CD
	  *                     FROM   MDM_LOCATION
	  *                     WHERE  LOC_CD = (SELECT LOC_CD
	  *                                      FROM   MDM_ORGANIZATION
	  *                                      WHERE  OFC_CD = @[ofc_cd]))
	  * AND    SC_PFX_CD = @[pre_fix]
	  * AND ROWNUM = 1
	  * 변경 PRI_SC_PFX 테이블에서만 CHECK한다.
	  * </pre>
	  */
	public SCProposalMainDBDAOPriSpHdrPreFixChkVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_fix",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPriSpHdrPreFixChkVORSQL").append("\n"); 
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
		query.append("SELECT SC_PFX_CD SVC_SCP_CD" ).append("\n"); 
		query.append("FROM PRI_SC_PFX" ).append("\n"); 
		query.append("WHERE SC_PFX_CD = @[pre_fix]" ).append("\n"); 
		query.append("AND DELT_FLG ='N'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}