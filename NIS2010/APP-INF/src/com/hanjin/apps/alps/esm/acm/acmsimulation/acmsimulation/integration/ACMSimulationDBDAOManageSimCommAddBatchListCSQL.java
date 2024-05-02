/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ACMSimulationDBDAOManageSimCommAddBatchListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSimulationDBDAOManageSimCommAddBatchListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 대상 Simulation Agreement 를 Batch 에 입력한다.
	  * 
	  * * 2014.06.03 박다은 [CHM-201430120] Agent Comm. Mass simulation 에 기능 추가
	  * </pre>
	  */
	public ACMSimulationDBDAOManageSimCommAddBatchListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_date_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_agmt_sml_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_date_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.integration").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOManageSimCommAddBatchListCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_CALC_BAT" ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("                BAT_RCV_DT" ).append("\n"); 
		query.append("               ,BAT_RCV_SEQ" ).append("\n"); 
		query.append("               ,BKG_NO" ).append("\n"); 
		query.append("               ,COMM_TP_CD " ).append("\n"); 
		query.append("               ,BAT_FLG" ).append("\n"); 
		query.append("               ,BAT_ITM_NM" ).append("\n"); 
		query.append("               ,BAT_DESC " ).append("\n"); 
		query.append("               ,CALC_FM_DT " ).append("\n"); 
		query.append("               ,CALC_TO_DT " ).append("\n"); 
		query.append("               ,AGN_AGMT_NO" ).append("\n"); 
		query.append("               ,CRE_USR_ID" ).append("\n"); 
		query.append("               ,CRE_DT" ).append("\n"); 
		query.append("               ,UPD_USR_ID" ).append("\n"); 
		query.append("               ,UPD_DT" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("    VALUES (" ).append("\n"); 
		query.append("               TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("              ,ACM_CALC_BAT_SEQ.NEXTVAL" ).append("\n"); 
		query.append("              ,@[sim_agmt_no]" ).append("\n"); 
		query.append("              ,'I'" ).append("\n"); 
		query.append("              ,'N'" ).append("\n"); 
		query.append("              ,@[sim_agmt_sml_no]" ).append("\n"); 
		query.append("              ,'MassSim(S)_'||@[sim_agmt_no]||'_'||to_char(sysdate,'yymmddhh24miss')" ).append("\n"); 
		query.append("              ,REPLACE(@[bkg_date_fm],'-','')" ).append("\n"); 
		query.append("              ,REPLACE(@[bkg_date_to],'-','')" ).append("\n"); 
		query.append("              ,@[sim_agmt_no]" ).append("\n"); 
		query.append("              ,@[usr_id]" ).append("\n"); 
		query.append("              ,SYSDATE" ).append("\n"); 
		query.append("              ,@[usr_id]" ).append("\n"); 
		query.append("              ,SYSDATE" ).append("\n"); 
		query.append("              )" ).append("\n"); 

	}
}