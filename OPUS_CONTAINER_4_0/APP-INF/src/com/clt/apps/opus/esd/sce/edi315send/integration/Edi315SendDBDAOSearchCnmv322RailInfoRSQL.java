/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Edi315SendDBDAOSearchCnmv322RailInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.22
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.04.22 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchCnmv322RailInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCnmv322RailInfo
	  * </pre>
	  */
	public Edi315SendDBDAOSearchCnmv322RailInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchCnmv322RailInfoRSQL").append("\n"); 
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
		query.append("select /*+ index_desc(d XPKSCE_COP_DTL) */" ).append("\n"); 
		query.append("  m.LOC_NM FRD_NAME," ).append("\n"); 
		query.append("  substr(d.nod_cd, 1, 5) FRD_CODE," ).append("\n"); 
		query.append("  TO_CHAR(d.ESTM_DT, 'YYYYMMDDHH24MI') FRDETA," ).append("\n"); 
		query.append("  TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(substr(d.nod_cd, 1, 5), d.ESTM_DT, 'GMT'), 'YYYYMMDDHH24MI') FRDETA_GMT" ).append("\n"); 
		query.append("from SCE_COP_DTL d," ).append("\n"); 
		query.append("  mdm_location m" ).append("\n"); 
		query.append("where d.cop_no = @[cop_no]" ).append("\n"); 
		query.append("  and d.act_cd = 'FIRRAD'" ).append("\n"); 
		query.append("  and m.loc_cd = substr(d.nod_cd, 1, 5)" ).append("\n"); 
		query.append("  and rownum   = 1" ).append("\n"); 

	}
}