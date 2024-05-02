/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTCommDBDAOCommissionDetailAmountVORSQL.java
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

public class AGTCommDBDAOCommissionDetailAmountVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_AGT_0011 화면 Commission Detail Amount 조회
	  * </pre>
	  */
	public AGTCommDBDAOCommissionDetailAmountVORSQL(){
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
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTCommDBDAOCommissionDetailAmountVORSQL").append("\n"); 
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
		query.append("DECODE(AC_TP_CD,'G','Common1'," ).append("\n"); 
		query.append("'N','Common2'," ).append("\n"); 
		query.append("'K','Brokerage'," ).append("\n"); 
		query.append("'H','CHF'," ).append("\n"); 
		query.append("'S','T/S'," ).append("\n"); 
		query.append("'R','T/R'," ).append("\n"); 
		query.append("'O','SOC'," ).append("\n"); 
		query.append("'C','Cross'," ).append("\n"); 
		query.append("'D','Doc') as AC_TP_CD," ).append("\n"); 
		query.append("SUM(ACT_IF_COMM_AMT) AS ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("SUM(ACT_IF_LOCL_COMM_AMT) AS ACT_IF_LOCL_COMM_AMT" ).append("\n"); 
		query.append(",DECODE(AC_TP_CD,'G',1,'N',2,'K',3,'H',4,'S',5,'R',6,'O',7,'C',8,'D',9) AS AC_TP_CD_NUM" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND AC_TP_CD <> 'T'" ).append("\n"); 
		query.append("AND AC_SEQ = @[ac_seq]" ).append("\n"); 
		query.append("GROUP BY AC_TP_CD" ).append("\n"); 
		query.append("ORDER BY 4" ).append("\n"); 

	}
}