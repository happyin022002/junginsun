/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ACMSimulationDBDAOGetMaxAcSeqInfoRSQL.java
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

public class ACMSimulationDBDAOGetMaxAcSeqInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetMaxAcSeqInfo
	  * 계산 시 Pay 프로세스에 따른 Max AC_SEQ 를 구한다.
	  * </pre>
	  */
	public ACMSimulationDBDAOGetMaxAcSeqInfoRSQL(){
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
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOGetMaxAcSeqInfoRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(AC_SEQ),0) + 1 as MAX_AC_SEQ" ).append("\n"); 
		query.append("FROM  ACM_SIM_COMM" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   SIM_NO    = @[sim_no]" ).append("\n"); 
		query.append("AND   BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("AND   AGN_CD    = @[agn_cd]" ).append("\n"); 
		query.append("AND   IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND   AC_TP_CD  = @[ac_tp_cd] " ).append("\n"); 

	}
}