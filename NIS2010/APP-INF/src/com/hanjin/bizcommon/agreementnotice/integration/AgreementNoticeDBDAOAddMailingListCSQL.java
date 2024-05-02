/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AgreementNoticeDBDAOAddMailingListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.26
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2014.03.26 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.agreementnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementNoticeDBDAOAddMailingListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddMailingList
	  * </pre>
	  */
	public AgreementNoticeDBDAOAddMailingListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_usr_id4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_n1st_usr_id_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_usr_id5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_usr_id6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_usr_id7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_usr_id1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_usr_id2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_usr_id3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_n3rd_usr_id_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_n2nd_usr_id_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_n6th_usr_id_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_mapg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("root_pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_n7th_usr_id_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_n5th_usr_id_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_n4th_usr_id_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.agreementnotice.integration").append("\n"); 
		query.append("FileName : AgreementNoticeDBDAOAddMailingListCSQL").append("\n"); 
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
		query.append("INSERT INTO COM_CTRT_USR_MGMT (" ).append("\n"); 
		query.append("SYS_CD" ).append("\n"); 
		query.append(", CTRT_OFC_CD" ).append("\n"); 
		query.append(", OFC_TP_CD" ).append("\n"); 
		query.append(", AGMT_NO" ).append("\n"); 
		query.append(", AGMT_MAPG_NO" ).append("\n"); 
		query.append(", ROOT_PGM_NO" ).append("\n"); 
		query.append(", NTC_USR_ID1" ).append("\n"); 
		query.append(", NTC_USR_ID2" ).append("\n"); 
		query.append(", NTC_USR_ID3" ).append("\n"); 
		query.append(", NTC_USR_ID4" ).append("\n"); 
		query.append(", NTC_USR_ID5" ).append("\n"); 
		query.append(", NTC_USR_ID6" ).append("\n"); 
		query.append(", NTC_USR_ID7" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", NTC_N1ST_USR_ID_JB_CD" ).append("\n"); 
		query.append(", NTC_N2ND_USR_ID_JB_CD" ).append("\n"); 
		query.append(", NTC_N3RD_USR_ID_JB_CD" ).append("\n"); 
		query.append(", NTC_N4TH_USR_ID_JB_CD" ).append("\n"); 
		query.append(", NTC_N5TH_USR_ID_JB_CD" ).append("\n"); 
		query.append(", NTC_N6TH_USR_ID_JB_CD" ).append("\n"); 
		query.append(", NTC_N7TH_USR_ID_JB_CD" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[sys_cd]" ).append("\n"); 
		query.append(", @[ctrt_ofc_cd]" ).append("\n"); 
		query.append(", @[ofc_tp_cd]" ).append("\n"); 
		query.append(", NVL(@[agmt_no],'ALL')" ).append("\n"); 
		query.append(", @[agmt_mapg_no]" ).append("\n"); 
		query.append(", @[root_pgm_no]" ).append("\n"); 
		query.append(", @[ntc_usr_id1]" ).append("\n"); 
		query.append(", @[ntc_usr_id2]" ).append("\n"); 
		query.append(", @[ntc_usr_id3]" ).append("\n"); 
		query.append(", @[ntc_usr_id4]" ).append("\n"); 
		query.append(", @[ntc_usr_id5]" ).append("\n"); 
		query.append(", @[ntc_usr_id6]" ).append("\n"); 
		query.append(", @[ntc_usr_id7]" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[ntc_n1st_usr_id_jb_cd]" ).append("\n"); 
		query.append(", @[ntc_n2nd_usr_id_jb_cd]" ).append("\n"); 
		query.append(", @[ntc_n3rd_usr_id_jb_cd]" ).append("\n"); 
		query.append(", @[ntc_n4th_usr_id_jb_cd]" ).append("\n"); 
		query.append(", @[ntc_n5th_usr_id_jb_cd]" ).append("\n"); 
		query.append(", @[ntc_n6th_usr_id_jb_cd]" ).append("\n"); 
		query.append(", @[ntc_n7th_usr_id_jb_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}