/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOredelivEurTroByCtmUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.12
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.04.12 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOredelivEurTroByCtmUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CTM에서 'REDELIVER'로 호출시 bkg_eur_tro를 update함
	  * </pre>
	  */
	public TransferOrderIssueDBDAOredelivEurTroByCtmUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_city_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("job_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("haulage_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOredelivEurTroByCtmUSQL").append("\n"); 
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
		query.append("--CTM에서 'REDELIVER'로 호출시 bkg_eur_tro를 update함" ).append("\n"); 
		query.append("UPDATE BKG_EUR_TRO" ).append("\n"); 
		query.append("SET CNTR_CFM_FLG    		= @[cfm_flag]" ).append("\n"); 
		query.append(", CNTR_CFM_USR_ID 		= @[usr_id]" ).append("\n"); 
		query.append(", CFM_UPD_DT     		= GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, GLOBALDATE_PKG.GET_LOCCD_FNC(@[ofc_cd]))" ).append("\n"); 
		query.append(", CNTR_RTN_YD_CD 	= @[yd_cd]" ).append("\n"); 
		query.append(", CNTR_RTN_DT  	= TO_DATE(@[job_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("#if(${haulage_cd} == 'M')" ).append("\n"); 
		query.append(", SO_CTY_CD 		= DECODE(@[cfm_flag], 'N', null, @[so_city_cd])" ).append("\n"); 
		query.append(", SO_SEQ_NO		= DECODE(@[cfm_flag], 'N', null, @[so_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", UPD_DT 			= sysdate" ).append("\n"); 
		query.append(", UPD_USR_ID 		= @[usr_id]" ).append("\n"); 
		query.append("WHERE BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bound_cd]" ).append("\n"); 
		query.append("AND HLG_TP_CD = @[haulage_cd]" ).append("\n"); 
		query.append("#if(${cfm_flag} == 'N' && ${haulage_cd} == 'M')" ).append("\n"); 
		query.append("AND SO_CTY_CD = @[so_city_cd]" ).append("\n"); 
		query.append("AND SO_SEQ_NO = @[so_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND TRO_SEQ   = @[tro_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}