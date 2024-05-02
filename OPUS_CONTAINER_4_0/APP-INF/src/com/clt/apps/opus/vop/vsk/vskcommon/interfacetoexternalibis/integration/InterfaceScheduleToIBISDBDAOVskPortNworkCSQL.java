/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceScheduleToIBISDBDAOVskPortNworkCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceScheduleToIBISDBDAOVskPortNworkCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ..
	  * </pre>
	  */
	public InterfaceScheduleToIBISDBDAOVskPortNworkCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.integration").append("\n"); 
		query.append("FileName : InterfaceScheduleToIBISDBDAOVskPortNworkCSQL").append("\n"); 
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
		query.append("#if (${if_mnpl_cd} == '') " ).append("\n"); 
		query.append("INSERT INTO VSK_PORT_NWORK_IBIS_IF" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("      LOC_CD" ).append("\n"); 
		query.append("    , HOL_SEQ" ).append("\n"); 
		query.append("    , IBIS_IF_SEQ" ).append("\n"); 
		query.append("    , IF_MNPL_CD" ).append("\n"); 
		query.append("    , HOL_ST_DT" ).append("\n"); 
		query.append("    , HOL_END_DT" ).append("\n"); 
		query.append("    , HOL_NM" ).append("\n"); 
		query.append("    , HOL_RMK" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , IF_SND_CD " ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("      @[loc_cd]" ).append("\n"); 
		query.append("    , '1'" ).append("\n"); 
		query.append("    , VSK_PORT_NWORK_IBIS_IF_SEQ.NEXTVAL" ).append("\n"); 
		query.append("    , 'D'" ).append("\n"); 
		query.append("    , ''" ).append("\n"); 
		query.append("    , ''" ).append("\n"); 
		query.append("    , ''" ).append("\n"); 
		query.append("    , ''" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , NVL((SELECT /*+ INDEX_DESC(A XPKVSK_PORT_NWORK_IBIS_IF) */ 'N'" ).append("\n"); 
		query.append("            FROM VSK_PORT_NWORK_IBIS_IF A WHERE LOC_CD=@[loc_cd] AND IF_SND_CD='Y' AND ROWNUM=1) ,'X')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO VSK_PORT_NWORK_IBIS_IF" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("      LOC_CD" ).append("\n"); 
		query.append("    , HOL_SEQ" ).append("\n"); 
		query.append("    , IBIS_IF_SEQ" ).append("\n"); 
		query.append("    , IF_MNPL_CD" ).append("\n"); 
		query.append("    , HOL_ST_DT" ).append("\n"); 
		query.append("    , HOL_END_DT" ).append("\n"); 
		query.append("    , HOL_NM" ).append("\n"); 
		query.append("    , HOL_RMK" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , IF_SND_CD " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("      LOC_CD" ).append("\n"); 
		query.append("    , HOL_SEQ" ).append("\n"); 
		query.append("    , VSK_PORT_NWORK_IBIS_IF_SEQ.NEXTVAL" ).append("\n"); 
		query.append("    , 'I'" ).append("\n"); 
		query.append("    , HOL_ST_DT" ).append("\n"); 
		query.append("    , HOL_END_DT" ).append("\n"); 
		query.append("    , HOL_NM" ).append("\n"); 
		query.append("    , HOL_RMK" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , 'N'" ).append("\n"); 
		query.append("FROM  VSK_PORT_NWORK" ).append("\n"); 
		query.append("WHERE LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}