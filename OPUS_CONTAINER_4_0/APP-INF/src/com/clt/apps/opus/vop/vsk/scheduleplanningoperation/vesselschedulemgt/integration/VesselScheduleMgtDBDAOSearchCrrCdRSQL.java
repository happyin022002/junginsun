/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchCrrCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.08
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2010.12.08 진마리아
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchCrrCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 화면에서 입력한 CRR_CD가 실제로 존재하는지 확인한다.
	  * 
	  * History
	  * * 2010.12.08 진마리아  CHM-201007135-01 Actaul Carrier update 로직 변경 요청건
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchCrrCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchCrrCdRSQL").append("\n"); 
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
		query.append("SELECT CRR_CD" ).append("\n"); 
		query.append("FROM MDM_CARRIER" ).append("\n"); 
		query.append("WHERE UPPER(CRR_CD) = UPPER(@[crr_cd])" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("GROUP BY CRR_CD" ).append("\n"); 

	}
}