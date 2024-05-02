/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOSearchOffHireTimeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOSearchOffHireTimeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Off-Hire Time List를 조회한다.
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOSearchOffHireTimeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOSearchOffHireTimeListRSQL").append("\n"); 
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
		query.append("SELECT	(TO_CHAR(V.VNOR_OFFH_FM_DT, 'yyyy.mm.dd.hh24:mi')" ).append("\n"); 
		query.append("			|| '-'" ).append("\n"); 
		query.append("			|| TO_CHAR(V.VNOR_OFFH_TO_DT, 'yyyy.mm.dd.hh24:mi')" ).append("\n"); 
		query.append("			|| V.CR_CHK_FLG" ).append("\n"); 
		query.append("			|| V.VNOR_SEQ" ).append("\n"); 
		query.append("		) AS INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("		,(TO_CHAR(V.VNOR_OFFH_FM_DT, 'yyyy.mm.dd.hh24:mi')" ).append("\n"); 
		query.append("			|| '~'" ).append("\n"); 
		query.append("			|| TO_CHAR(V.VNOR_OFFH_TO_DT, 'yyyy.mm.dd.hh24:mi')" ).append("\n"); 
		query.append("			|| ' : '" ).append("\n"); 
		query.append("			|| (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03389' AND INTG_CD_VAL_CTNT = V.VNOR_STUP_STS_CD)" ).append("\n"); 
		query.append("		) AS INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM OPF_VNOR V" ).append("\n"); 
		query.append("WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("ORDER BY VNOR_SEQ" ).append("\n"); 

	}
}