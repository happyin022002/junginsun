/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfMrnSailDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.28
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfMrnSailDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfMrnSailDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfMrnSailDtRSQL").append("\n"); 
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
		query.append("SELECT MAX(MF_REF_NO) MF_REF_NO," ).append("\n"); 
		query.append("		MAX(SAIL_DT) SAIL_DT," ).append("\n"); 
		query.append("		MAX(WHF_DECL_NO) WHF_DECL_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append(" MF_REF_NO" ).append("\n"); 
		query.append(",TO_CHAR(TO_DATE(SAIL_DT, 'YYYYMMDD'), 'YYYY-MM-DD') AS SAIL_DT" ).append("\n"); 
		query.append(",'' WHF_DECL_NO" ).append("\n"); 
		query.append("FROM BKG_KR_WHF_VOL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND VSL_CD     = SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("AND WHF_BND_CD IN (DECODE(@[whf_bnd_cd], 'IN', 'II', @[whf_bnd_cd]), DECODE(@[whf_bnd_cd], 'IN', 'IT', @[whf_bnd_cd]))" ).append("\n"); 
		query.append("AND PORT_CD    = @[port_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '' MF_REF_NO, '' SAIL_DT, WHF_DECL_NO FROM BKG_KR_WHF_RT" ).append("\n"); 
		query.append(" WHERE VSL_CD = SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append(" AND SKD_VOY_NO = SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append(" AND SKD_DIR_CD = SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append(" AND WHF_BND_CD = @[whf_bnd_cd]" ).append("\n"); 
		query.append(" AND PORT_CD = @[port_cd]" ).append("\n"); 
		query.append(" AND WHF_DECL_NO IS NOT NULL" ).append("\n"); 
		query.append(" AND ROWNUM = 1)" ).append("\n"); 

	}
}