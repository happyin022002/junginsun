/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchEdiHdVslSkdCstSkdBerthWdoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.09
*@LastModifier : 
*@LastVersion : 1.0
* 2017.02.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchEdiHdVslSkdCstSkdBerthWdoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * KL-Net EDI 전송을 위한 헤더 생성
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchEdiHdVslSkdCstSkdBerthWdoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("klnet",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchEdiHdVslSkdCstSkdBerthWdoRSQL").append("\n"); 
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
		query.append("      '$$$MSGSTART:'||" ).append("\n"); 
		query.append("      RPAD('SMLMM010',20,' ')||" ).append("\n"); 
		query.append("      RPAD(@[klnet],20,' ')||" ).append("\n"); 
		query.append("      RPAD('IFTSAI',10,' ')||" ).append("\n"); 
		query.append("--    'KOR'||TO_CHAR(SYSDATE,'RRMMDD')||LTRIM(TO_CHAR(EDI_SEQ.NEXTVAL,'00009'),' ')" ).append("\n"); 
		query.append("      '00001' STR_HEADER" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}