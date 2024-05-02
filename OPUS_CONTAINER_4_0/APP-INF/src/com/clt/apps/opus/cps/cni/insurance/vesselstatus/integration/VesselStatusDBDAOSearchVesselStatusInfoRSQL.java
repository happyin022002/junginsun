/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselStatusDBDAOSearchVesselStatusInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.16
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2010.04.16 양정란
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.insurance.vesselstatus.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yang jung ran
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselStatusDBDAOSearchVesselStatusInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert 전 중복체크개념
	  * </pre>
	  */
	public VesselStatusDBDAOSearchVesselStatusInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_plcy_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.insurance.vesselstatus.integration").append("\n"); 
		query.append("FileName : VesselStatusDBDAOSearchVesselStatusInfoRSQL").append("\n"); 
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
		query.append("    'Y' EXIST" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    DUAL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    EXISTS" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("		SELECT" ).append("\n"); 
		query.append("		    INSUR_TP_CD" ).append("\n"); 
		query.append("		FROM" ).append("\n"); 
		query.append("		    CNI_INSUR_CTRT_DTL" ).append("\n"); 
		query.append("		WHERE" ).append("\n"); 
		query.append("		    INSUR_TP_CD          = @[insur_tp_cd]" ).append("\n"); 
		query.append("		    AND INSUR_PLCY_YR    = @[insur_plcy_yr]" ).append("\n"); 
		query.append("		    AND INSUR_CLM_PTY_NO = @[insur_clm_pty_no]" ).append("\n"); 
		query.append("		    AND VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("		    AND INSUR_EFF_DT     = @[insur_eff_dt]" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}