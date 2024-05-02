/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InputDataRLAExamineDBDAOUpdateRLALinkInfo_20QueryUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.11.05 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InputDataRLAExamineDBDAOUpdateRLALinkInfo_20QueryUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_SCNR_ECC_LNK 테이블에 대한 20feet amount  수정
	  * </pre>
	  */
	public InputDataRLAExamineDBDAOUpdateRLALinkInfo_20QueryUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tz_20ft_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.integration").append("\n"); 
		query.append("FileName : InputDataRLAExamineDBDAOUpdateRLALinkInfo_20QueryUSQL").append("\n"); 
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
		query.append("UPDATE EQR_SCNR_ECC_LNK  SET" ).append("\n"); 
		query.append("TZ_20FT_COST_AMT   = @[tz_20ft_cost_amt]" ).append("\n"); 
		query.append(",	UPD_USR_ID         = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT             = SYSDATE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SCNR_ID          	= @[scnr_id]" ).append("\n"); 
		query.append("AND   FM_ECC_CD	    = @[fm_ecc_cd]" ).append("\n"); 
		query.append("AND   TO_ECC_CD	    = @[to_ecc_cd]" ).append("\n"); 
		query.append("AND   TRSP_MOD_CD   = @[trsp_mod_cd]" ).append("\n"); 

	}
}