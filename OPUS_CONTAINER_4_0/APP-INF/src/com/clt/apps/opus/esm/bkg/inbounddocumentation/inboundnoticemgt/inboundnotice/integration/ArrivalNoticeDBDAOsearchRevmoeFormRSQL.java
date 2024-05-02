/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArrivalNoticeDBDAOsearchRevmoeFormRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOsearchRevmoeFormRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 0375에서 삭제할 폼을 선택하는 로직을 구현한다.
	  * POD(ALL) AGENT(ALL)    - 모두
	  * POD(ALL) AGENT(CODE) - 해당 단건
	  * POD(CODE) AGENT(ALL) - Agent모두
	  * POD(CODE) AGENT(CODE) - 해당 단건
	  * </pre>
	  */
	public ArrivalNoticeDBDAOsearchRevmoeFormRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chn_agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration ").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOsearchRevmoeFormRSQL").append("\n"); 
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
		query.append("SELECT AN_SEQ" ).append("\n"); 
		query.append("FROM BKG_ARR_NTC_WD" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#if(${pod_cd} == '*' && ${chn_agn_cd} == '*' )" ).append("\n"); 
		query.append("AND 1 = 1  -- 해당되는 모든 Form(multi)" ).append("\n"); 
		query.append("#elseif (${pod_cd} == '*' && ${chn_agn_cd} != '*' )" ).append("\n"); 
		query.append("AND POD_CD = '*'" ).append("\n"); 
		query.append("AND CHN_AGN_CD = @[chn_agn_cd] -- 해당 데이터 (single)" ).append("\n"); 
		query.append("#elseif (${pod_cd} != '*' && ${chn_agn_cd} == '*' )" ).append("\n"); 
		query.append("AND POD_CD = @[pod_cd] -- POD에 해당되는 모든 데이터 (multi)" ).append("\n"); 
		query.append("#elseif (${pod_cd} != '*' && ${chn_agn_cd} != '*' )" ).append("\n"); 
		query.append("AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("AND CHN_AGN_CD = @[chn_agn_cd]  -- pod agent에 해당하는 데이터 (single)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND 1 = 0  -- null값등이 들어오면 삭제하면 안되게 처리" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}