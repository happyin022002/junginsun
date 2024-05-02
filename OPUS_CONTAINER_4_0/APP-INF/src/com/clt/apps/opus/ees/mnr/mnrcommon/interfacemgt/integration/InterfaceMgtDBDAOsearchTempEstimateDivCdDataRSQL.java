/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchTempEstimateDivCdDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.01
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.09.01 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOsearchTempEstimateDivCdDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTempEstimateDivCdData
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchTempEstimateDivCdDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_cmpo_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_rpr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_lbr_hrs",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchTempEstimateDivCdDataRSQL").append("\n"); 
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
		query.append("SELECT TO_RLT_CD AS DIV_CD" ).append("\n"); 
		query.append("FROM MNR_CD_RLT" ).append("\n"); 
		query.append("WHERE FM_RLT_CD = @[eq_cmpo_cd] || @[eq_rpr_cd]" ).append("\n"); 
		query.append("AND EQ_CEDEX_RLT_TP_CD  = 'CTV'" ).append("\n"); 
		query.append("AND RPR_LBR_HRS = @[rpr_lbr_hrs]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}