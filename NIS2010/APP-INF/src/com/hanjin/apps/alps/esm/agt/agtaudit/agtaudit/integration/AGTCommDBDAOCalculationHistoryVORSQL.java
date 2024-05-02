/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTCommDBDAOCalculationHistoryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCommDBDAOCalculationHistoryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_AGT_0011 화면 Calculation History 조회
	  * </pre>
	  */
	public AGTCommDBDAOCalculationHistoryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTCommDBDAOCalculationHistoryVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("AC_SEQ AS AC_SEQ," ).append("\n"); 
		query.append("MAX(TO_CHAR(CRE_DT,'YYYYMMDD')) AS CRE_DT," ).append("\n"); 
		query.append("SUM(DECODE(AC_TP_CD,'G',ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("'N',ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("'K',ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("'H',ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("'S',ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("'R',ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("'O',ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("'C',ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("'D',ACT_IF_COMM_AMT,0)) AS ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("SUM(DECODE(AC_TP_CD,'G',ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("'N',ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("'K',ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("'H',ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("'S',ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("'R',ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("'O',ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("'C',ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("'D',ACT_IF_LOCL_COMM_AMT,0)) AS ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("MAX(DECODE(XCH_RT_APLY_LVL,'1',VVD_XCH_RT," ).append("\n"); 
		query.append("'2',MON_XCH_RT," ).append("\n"); 
		query.append("'4',MON_XCH_RT,DLY_XCH_RT)) AS XCH_RT" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM" ).append("\n"); 
		query.append("WHERE BKG_NO =	@[bkg_no]" ).append("\n"); 
		query.append("AND AGN_CD =	@[agn_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND AC_TP_CD	<> 'T'" ).append("\n"); 
		query.append("GROUP BY AC_SEQ" ).append("\n"); 
		query.append("ORDER BY AC_SEQ" ).append("\n"); 

	}
}