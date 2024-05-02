/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferOrderIssueDBDAOconfirmEurTroByCtmUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.12.08 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOconfirmEurTroByCtmUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ctm에서 'RELEASE'로 호출시 bkg_eur_tro에 update한다.
	  * </pre>
	  */
	public TransferOrderIssueDBDAOconfirmEurTroByCtmUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOconfirmEurTroByCtmUSQL").append("\n"); 
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
		query.append("UPDATE BKG_EUR_TRO" ).append("\n"); 
		query.append("SET CNTR_CFM_FLG    	= @[cfm_flag]" ).append("\n"); 
		query.append(", CNTR_CFM_USR_ID 	= @[usr_id]" ).append("\n"); 
		query.append(", CFM_UPD_DT  		= GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, GLOBALDATE_PKG.GET_LOCCD_FNC(@[ofc_cd]))" ).append("\n"); 
		query.append(", CNTR_PKUP_YD_CD 	= @[yd_cd]" ).append("\n"); 
		query.append(", CNTR_PKUP_DT 	= TO_DATE(@[job_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("#if(${haulage_cd} == 'M')" ).append("\n"); 
		query.append(", SO_CTY_CD 		= DECODE(@[cfm_flag], 'N', null, @[so_city_cd])" ).append("\n"); 
		query.append(", SO_SEQ_NO		= DECODE(@[cfm_flag], 'N', null, @[so_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", UPD_DT 			= sysdate" ).append("\n"); 
		query.append(", UPD_USR_ID 		= @[usr_id]" ).append("\n"); 
		query.append("WHERE  BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND    IO_BND_CD    = @[bound_cd]" ).append("\n"); 
		query.append("AND    TRO_SEQ      = @[tro_seq]" ).append("\n"); 

	}
}