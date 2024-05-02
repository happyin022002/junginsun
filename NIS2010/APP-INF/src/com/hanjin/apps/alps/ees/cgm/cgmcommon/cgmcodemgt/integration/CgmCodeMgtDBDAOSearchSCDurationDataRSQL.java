/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CgmCodeMgtDBDAOSearchSCDurationDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOSearchSCDurationDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * 2014-01-10 Jonghee HAN 01-09 회의결과 Effective date를 현재 system date에서 2014-01-01로 변경하고 현재처럼 수정 가능하도록 변경(한시적으로 적용후 system date로 변경) 
	  * 2014-04-04 by Jonghee HAN CSR Ticket : CHM-201429628, Title : Pricing-S/C Creation and Amendation 시, Amend Button 활성화 요청, PRI를 통한 Chassis S/C Exception Creation시 Effective date : 2014-01-01 Fix Logic 복원
	  * 2014-06-24 by Chang Young Kim SR Ticket : SRM-201445510 : update시 해당 prop_no의 max(amdt_seq)에 해당하는 PROP_STS_CD가 "I"가 아닐경우 Return
	  * ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public CgmCodeMgtDBDAOSearchSCDurationDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOSearchSCDurationDataRSQL").append("\n"); 
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
		query.append("SELECT	TO_CHAR(EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("	,   TO_CHAR(EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("	,   PROP_STS_CD" ).append("\n"); 
		query.append("FROM	PRI_SP_MN SP" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("#if(${prop_no} == '')" ).append("\n"); 
		query.append("	AND SP.PROP_NO = (SELECT DISTINCT PROP_NO" ).append("\n"); 
		query.append("						FROM PRI_SP_HDR" ).append("\n"); 
		query.append("					   WHERE SC_NO = @[sc_no])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND SP.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${amdt_seq} != '')" ).append("\n"); 
		query.append("	AND	SP.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND" ).append("\n"); 
		query.append("		SP.AMDT_SEQ = " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT	/*+ INDEX_DESC(PRI_SP_MN XPKPRI_SP_MN) */ AMDT_SEQ" ).append("\n"); 
		query.append("			FROM	PRI_SP_MN" ).append("\n"); 
		query.append("			WHERE	PROP_NO = SP.PROP_NO" ).append("\n"); 
		query.append("			AND	ROWNUM = 1" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}