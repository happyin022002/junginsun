/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOGetVADActualMappingInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2010.02.17 오현경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Oh hyun-kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOGetVADActualMappingInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getVADActualMappingInfo
	  * </pre>
	  */
	public Edi315SendDBDAOGetVADActualMappingInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOGetVADActualMappingInfoRSQL").append("\n"); 
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
		query.append("select SUM(act_dt) act_dt, MAX(cop_dtl_seq) cop_dtl_seq" ).append("\n"); 
		query.append("from(" ).append("\n"); 
		query.append("select DECODE(stnd_edi_sts_cd, 'VAD', NVL2(act_dt,1,0), 0) act_dt, cop_dtl_seq" ).append("\n"); 
		query.append("from sce_cop_dtl" ).append("\n"); 
		query.append("where cop_no = @[e_cop_no]" ).append("\n"); 
		query.append("and stnd_edi_sts_cd  in( 'VAD', 'UVD')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}