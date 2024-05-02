/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SettlementProcessDBDAOJoSettlementPicRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.26
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2016.01.26 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementProcessDBDAOJoSettlementPicRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 정산 PIC 담당자 조회
	  * </pre>
	  */
	public SettlementProcessDBDAOJoSettlementPicRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pic",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOJoSettlementPicRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append(" J.TRD_CD" ).append("\n"); 
		query.append(",J.CRR_CD" ).append("\n"); 
		query.append(",J.RLANE_CD" ).append("\n"); 
		query.append(",J.RE_DIVR_CD" ).append("\n"); 
		query.append(",J.STL_PIC_NM AS PIC" ).append("\n"); 
		query.append("FROM  JOO_STL_PIC J" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append(" 		    #if (${trd_cd} != '')" ).append("\n"); 
		query.append("			AND J.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("			#end			" ).append("\n"); 
		query.append(" 		    #if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("			AND J.CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("			#end			" ).append("\n"); 
		query.append(" 		    #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("			AND J.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("			#end			" ).append("\n"); 
		query.append(" 		    #if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("			AND J.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("			#end			" ).append("\n"); 
		query.append(" 		    #if (${pic} != 'ALL')" ).append("\n"); 
		query.append("	 		    #if (${pic} == '')" ).append("\n"); 
		query.append("					AND J.STL_PIC_NM IS NULL" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					AND J.STL_PIC_NM LIKE '%' || @[pic] || '%'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end			" ).append("\n"); 
		query.append("ORDER BY J.TRD_CD, J.RLANE_CD, J.CRR_CD, J.RE_DIVR_CD ASC" ).append("\n"); 

	}
}