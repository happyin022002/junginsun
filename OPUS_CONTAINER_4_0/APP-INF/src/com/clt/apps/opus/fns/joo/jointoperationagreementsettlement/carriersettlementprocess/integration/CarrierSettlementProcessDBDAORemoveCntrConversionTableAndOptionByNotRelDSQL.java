/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAORemoveCntrConversionTableAndOptionByNotRelDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAORemoveCntrConversionTableAndOptionByNotRelDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Relation Delete
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAORemoveCntrConversionTableAndOptionByNotRelDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppt_cd2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration ").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAORemoveCntrConversionTableAndOptionByNotRelDSQL").append("\n"); 
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
		query.append("#if (${ppt_cd} != '' && ${ppt_cd} == 'TEU CONVERSION')" ).append("\n"); 
		query.append("DELETE" ).append("\n"); 
		query.append("  FROM JOO_COM_PPT A" ).append("\n"); 
		query.append(" WHERE A.PPT_CD= @[ppt_cd]" ).append("\n"); 
		query.append("   AND A.ATTR_CTNT2 NOT IN (SELECT DISTINCT B.ATTR_CTNT2" ).append("\n"); 
		query.append("                              FROM JOO_COM_PPT B" ).append("\n"); 
		query.append("                             WHERE B.PPT_CD = @[ppt_cd2] )" ).append("\n"); 
		query.append("#elseif (${ppt_cd} != '' && ${ppt_cd} == 'VOID CONVERSION') " ).append("\n"); 
		query.append("DELETE" ).append("\n"); 
		query.append("  FROM JOO_COM_PPT A" ).append("\n"); 
		query.append(" WHERE A.PPT_CD= @[ppt_cd]" ).append("\n"); 
		query.append("   AND A.ATTR_CTNT1 NOT IN (SELECT DISTINCT B.ATTR_CTNT1" ).append("\n"); 
		query.append("                              FROM JOO_COM_PPT B" ).append("\n"); 
		query.append("                             WHERE B.PPT_CD = @[ppt_cd2] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}