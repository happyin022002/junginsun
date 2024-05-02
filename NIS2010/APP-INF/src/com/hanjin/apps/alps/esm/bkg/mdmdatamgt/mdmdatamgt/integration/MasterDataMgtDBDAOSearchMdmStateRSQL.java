/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MasterDataMgtDBDAOSearchMdmStateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.31
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MasterDataMgtDBDAOSearchMdmStateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 중국 Booking Agent 정보 등록 화면
	  * </pre>
	  */
	public MasterDataMgtDBDAOSearchMdmStateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ind_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.integration").append("\n"); 
		query.append("FileName : MasterDataMgtDBDAOSearchMdmStateRSQL").append("\n"); 
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
		query.append("STE_CD" ).append("\n"); 
		query.append(", IDA_STE_CD AS IND_STE_CD" ).append("\n"); 
		query.append(", IDA_TERR_DIV_CD AS IND_TERR_DIV_CD" ).append("\n"); 
		query.append(", DECODE(IND_TERR_DIV_CD, 'S', 'State', 'UT') IND_TERR_DIV_NM" ).append("\n"); 
		query.append(", STE_NM" ).append("\n"); 
		query.append("FROM MDM_STATE" ).append("\n"); 
		query.append("WHERE 1 =1" ).append("\n"); 
		query.append("AND CNT_CD='IN'" ).append("\n"); 
		query.append("AND DELT_FLG ='N'" ).append("\n"); 
		query.append("#if (${ind_ste_cd} != '' ) " ).append("\n"); 
		query.append("  AND IDA_STE_CD = @[ind_ste_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ste_nm} != '' ) " ).append("\n"); 
		query.append("  AND STE_NM LIKE '%' ||@[ste_nm]|| '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY IND_STE_CD" ).append("\n"); 

	}
}