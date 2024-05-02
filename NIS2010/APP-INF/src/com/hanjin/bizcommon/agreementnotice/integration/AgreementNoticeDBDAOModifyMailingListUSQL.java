/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AgreementNoticeDBDAOModifyMailingListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.27
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2014.03.27 채창호
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

public class AgreementNoticeDBDAOModifyMailingListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyMailingList
	  * </pre>
	  */
	public AgreementNoticeDBDAOModifyMailingListUSQL(){
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
		params.put("ntc_usr_id5",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ntc_n7th_usr_id_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ntc_n4th_usr_id_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.agreementnotice.integration").append("\n"); 
		query.append("FileName : AgreementNoticeDBDAOModifyMailingListUSQL").append("\n"); 
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
		query.append("UPDATE COM_CTRT_USR_MGMT" ).append("\n"); 
		query.append("SET NTC_USR_ID1 = @[ntc_usr_id1]" ).append("\n"); 
		query.append(", NTC_USR_ID2 = @[ntc_usr_id2]" ).append("\n"); 
		query.append(", NTC_USR_ID3 = @[ntc_usr_id3]" ).append("\n"); 
		query.append(", NTC_USR_ID4 = @[ntc_usr_id4]" ).append("\n"); 
		query.append(", NTC_USR_ID5 = @[ntc_usr_id5]" ).append("\n"); 
		query.append(", NTC_USR_ID6 = @[ntc_usr_id6]" ).append("\n"); 
		query.append(", NTC_USR_ID7 = @[ntc_usr_id7]" ).append("\n"); 
		query.append(", UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT      = SYSDATE" ).append("\n"); 
		query.append(", NTC_N1ST_USR_ID_JB_CD = @[ntc_n1st_usr_id_jb_cd]" ).append("\n"); 
		query.append(", NTC_N2ND_USR_ID_JB_CD = @[ntc_n2nd_usr_id_jb_cd]" ).append("\n"); 
		query.append(", NTC_N3RD_USR_ID_JB_CD = @[ntc_n3rd_usr_id_jb_cd]" ).append("\n"); 
		query.append(", NTC_N4TH_USR_ID_JB_CD = @[ntc_n4th_usr_id_jb_cd]" ).append("\n"); 
		query.append(", NTC_N5TH_USR_ID_JB_CD = @[ntc_n5th_usr_id_jb_cd]" ).append("\n"); 
		query.append(", NTC_N6TH_USR_ID_JB_CD = @[ntc_n6th_usr_id_jb_cd]" ).append("\n"); 
		query.append(", NTC_N7TH_USR_ID_JB_CD = @[ntc_n7th_usr_id_jb_cd]" ).append("\n"); 
		query.append("WHERE SYS_CD      = @[sys_cd]" ).append("\n"); 
		query.append("AND CTRT_OFC_CD = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("AND OFC_TP_CD   = @[ofc_tp_cd]" ).append("\n"); 
		query.append("AND AGMT_NO     = NVL(@[agmt_no],'ALL')" ).append("\n"); 

	}
}