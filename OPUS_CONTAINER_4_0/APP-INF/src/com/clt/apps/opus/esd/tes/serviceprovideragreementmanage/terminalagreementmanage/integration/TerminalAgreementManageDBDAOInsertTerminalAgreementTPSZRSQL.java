/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOInsertTerminalAgreementTPSZRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.01.25 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOInsertTerminalAgreementTPSZRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TMNL Agmt TPSZ 조회
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOInsertTerminalAgreementTPSZRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOInsertTerminalAgreementTPSZRSQL").append("\n"); 
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
		query.append("SELECT  cntr_tpsz_cd, cntr_tpsz_savename" ).append("\n"); 
		query.append("FROM	(SELECT cntr_tpsz_cd, 'tesAgreementManageCommonVO.get'||cntr_tpsz_cd||'()' cntr_tpsz_savename" ).append("\n"); 
		query.append("FROM	MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("WHERE cntr_tp_cd = 'D'" ).append("\n"); 
		query.append("--// MDM_CNTR_TP_SZ에 D3 추가로 인해 TES AGMT에서 사용하지 않는 D3 제외 로직 추가 ( 4342. 01. 22 - 이경한 과장 요청 )" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD <> 'D3'" ).append("\n"); 
		query.append("ORDER BY  cntr_sz_cd )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	cntr_tpsz_cd, cntr_tpsz_savename" ).append("\n"); 
		query.append("FROM	(SELECT cntr_tpsz_cd, 'tesAgreementManageCommonVO.get'||cntr_tpsz_cd||'()' cntr_tpsz_savename" ).append("\n"); 
		query.append("FROM	MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("WHERE	cntr_tp_cd = 'R'" ).append("\n"); 
		query.append("ORDER BY  cntr_sz_cd )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  cntr_tpsz_cd, cntr_tpsz_savename" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT cntr_tpsz_cd, 'tesAgreementManageCommonVO.get'||cntr_tpsz_cd||'()' cntr_tpsz_savename" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("WHERE	cntr_tp_cd = 'F'" ).append("\n"); 
		query.append("ORDER BY  cntr_sz_cd )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  cntr_tpsz_cd, cntr_tpsz_savename" ).append("\n"); 
		query.append("FROM	(SELECT cntr_tpsz_cd, 'tesAgreementManageCommonVO.get'||cntr_tpsz_cd||'()' cntr_tpsz_savename" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("WHERE	cntr_tp_cd = 'O'" ).append("\n"); 
		query.append("ORDER BY  cntr_sz_cd )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  cntr_tpsz_cd, cntr_tpsz_savename" ).append("\n"); 
		query.append("FROM	(SELECT cntr_tpsz_cd, 'tesAgreementManageCommonVO.get'||cntr_tpsz_cd||'()' cntr_tpsz_savename" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("WHERE	cntr_tp_cd = 'S'" ).append("\n"); 
		query.append("ORDER BY  cntr_sz_cd )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  cntr_tpsz_cd, cntr_tpsz_savename" ).append("\n"); 
		query.append("FROM	(SELECT cntr_tpsz_cd, 'tesAgreementManageCommonVO.get'||cntr_tpsz_cd||'()' cntr_tpsz_savename" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("WHERE	cntr_tp_cd = 'T'" ).append("\n"); 
		query.append("ORDER BY  cntr_sz_cd )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  cntr_tpsz_cd, cntr_tpsz_savename" ).append("\n"); 
		query.append("FROM	(SELECT cntr_tpsz_cd, 'tesAgreementManageCommonVO.get'||cntr_tpsz_cd||'()' cntr_tpsz_savename" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("WHERE	cntr_tp_cd = 'A'" ).append("\n"); 
		query.append("ORDER BY  cntr_sz_cd )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  cntr_tpsz_cd, cntr_tpsz_savename" ).append("\n"); 
		query.append("FROM	(SELECT cntr_tpsz_cd, 'tesAgreementManageCommonVO.get'||cntr_tpsz_cd||'()' cntr_tpsz_savename" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("WHERE	cntr_tp_cd = 'P'" ).append("\n"); 
		query.append("ORDER BY  cntr_sz_cd )" ).append("\n"); 

	}
}