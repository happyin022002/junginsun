/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOOfficeMgtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.11 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMMasterCodeMgtDBDAOOfficeMgtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office검색조건 VO
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOOfficeMgtRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("select" ).append("\n"); 
		query.append("'' sch_hohq_gbn" ).append("\n"); 
		query.append(",'' sch_lvl1" ).append("\n"); 
		query.append(",'' sch_lvl2" ).append("\n"); 
		query.append(",'' sch_lvl3" ).append("\n"); 
		query.append(",'' sch_office_gbn" ).append("\n"); 
		query.append(",'' sch_office_code" ).append("\n"); 
		query.append(",'' sch_office_lvl" ).append("\n"); 
		query.append(",'' sch_com_div" ).append("\n"); 
		query.append(",'' sch_app_div_gbn" ).append("\n"); 
		query.append(",'' sch_sumup_gbn" ).append("\n"); 
		query.append(",'' sch_sumup_office" ).append("\n"); 
		query.append(",'' sch_delt_flg" ).append("\n"); 
		query.append(",'' str_app_div_sql" ).append("\n"); 
		query.append(",'' sch_expn_group" ).append("\n"); 
		query.append(",'' sch_gen_expn_cd" ).append("\n"); 
		query.append(",'' sch_lang" ).append("\n"); 
		query.append(",'' hdn_ofc_cd" ).append("\n"); 
		query.append(",'' hdn_gen_expn_cd" ).append("\n"); 
		query.append(",'' hdn_sls_ofc_flg" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOOfficeMgtRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}