/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ACMSimulationDBDAOGetChgAmtRtInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSimulationDBDAOGetChgAmtRtInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetChgAmtRtInfo
	  * </pre>
	  */
	public ACMSimulationDBDAOGetChgAmtRtInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_rev_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOGetChgAmtRtInfoRSQL").append("\n"); 
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
		query.append("  @[ttl_rev_amt]    AS COMM_REV" ).append("\n"); 
		query.append(", DDCT_SPCL" ).append("\n"); 
		query.append(", DDCT_CHG" ).append("\n"); 
		query.append(", DDCT_TRS" ).append("\n"); 
		query.append(", (@[ttl_rev_amt] - (DDCT_SPCL + DDCT_CHG + DDCT_TRS)) * NVL(@[comm_rt],0) / 100 AS COMM_AMT  " ).append("\n"); 
		query.append(", PPD_CRNT_AMT" ).append("\n"); 
		query.append(", PPD_PAY_CRNT_AMT" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("        SELECT NVL(SUM(S.IF_AMT),0)        AS DDCT_SPCL FROM ACM_SPCL_CMPN S     WHERE S.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    )SPCL,(" ).append("\n"); 
		query.append("        SELECT NVL(SUM(C.CHG_DDCT_AMT),0)  AS DDCT_CHG  FROM ACM_SIM_COMM_CHG C  WHERE C.SIM_NO = @[sim_no] and C.BKG_NO = @[bkg_no] and AGN_CD = @[agn_cd] and IO_BND_CD = @[io_bnd_cd] and AC_TP_CD = @[ac_tp_cd] and AC_SEQ = @[max_ac_seq]" ).append("\n"); 
		query.append("    )CHG,(" ).append("\n"); 
		query.append("        SELECT NVL(SUM(T.TRSP_DDCT_AMT),0) AS DDCT_TRS  FROM ACM_SIM_COMM_TRSP T WHERE T.SIM_NO = @[sim_no] and T.BKG_NO = @[bkg_no] and AGN_CD = @[agn_cd] and IO_BND_CD = @[io_bnd_cd] and AC_TP_CD = @[ac_tp_cd] and AC_SEQ = @[max_ac_seq]" ).append("\n"); 
		query.append("    )TRS,(" ).append("\n"); 
		query.append("        SELECT NVL(SUM(A.CRNT_AMT),0) AS PPD_CRNT_AMT , NVL(SUM(A.PAY_CRNT_AMT),0) AS PPD_PAY_CRNT_AMT" ).append("\n"); 
		query.append("                                                        FROM ACM_SIM_COMM A      WHERE A.SIM_NO = @[sim_no] and A.BKG_NO = @[bkg_no] and AGN_CD = @[agn_cd] and IO_BND_CD = @[io_bnd_cd] and AC_TP_CD = @[ac_tp_cd] and AC_SEQ = @[max_ac_seq] - 1" ).append("\n"); 
		query.append("    )PPD_ACM_COMM" ).append("\n"); 

	}
}