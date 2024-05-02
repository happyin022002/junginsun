/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOIsTempSavedStatusOfLastVersionProgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOIsTempSavedStatusOfLastVersionProgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C 에 생성된 이력중 마지막 이력의 S/C Exception Tariff 의 상태가 'Temp.Saved' 인지를 조회하기 위한 쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOIsTempSavedStatusOfLastVersionProgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_expt_ver_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOIsTempSavedStatusOfLastVersionProgRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(PROP_NO)" ).append("\n"); 
		query.append("FROM    DMT_SC_EXPT_VER_PROG SC_VER_PROG" ).append("\n"); 
		query.append("WHERE   PROP_NO 		= @[prop_no]" ).append("\n"); 
		query.append("AND SC_EXPT_VER_SEQ = @[sc_expt_ver_seq]" ).append("\n"); 
		query.append("AND PROG_SEQ 		=" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  NVL(MAX(PROG_SEQ), 0)" ).append("\n"); 
		query.append("FROM    DMT_SC_EXPT_VER_PROG" ).append("\n"); 
		query.append("WHERE   PROP_NO         = SC_VER_PROG.PROP_NO" ).append("\n"); 
		query.append("AND SC_EXPT_VER_SEQ = SC_VER_PROG.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND DMDT_EXPT_VER_STS_CD = @[dmdt_expt_ver_sts_cd]" ).append("\n"); 

	}
}