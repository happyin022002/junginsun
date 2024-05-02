/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : UserOfcCngDBDAOSearchUserListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2011.03.08 김경범
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.user.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kyungbum kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserOfcCngDBDAOSearchUserListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * user의 모든 목록을 가져온다
	  * </pre>
	  */
	public UserOfcCngDBDAOSearchUserListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.user.integration").append("\n"); 
		query.append("FileName : UserOfcCngDBDAOSearchUserListRSQL").append("\n"); 
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
		query.append("#if(${admin_page} == 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	A.USR_ID," ).append("\n"); 
		query.append("	A.USR_NM," ).append("\n"); 
		query.append("	A.USR_LOCL_NM," ).append("\n"); 
		query.append("	A.OFC_CD," ).append("\n"); 
		query.append("	B.CNG_OFC_CD," ).append("\n"); 
		query.append("	NVL(C.AR_HD_QTR_OFC_CD, B.CNG_OFC_CD) RHQ," ).append("\n"); 
		query.append("	TO_CHAR(B.CNG_OFC_FM_DT,'YYYYMMDD') CNG_OFC_FM_DT," ).append("\n"); 
		query.append("	TO_CHAR(DECODE(C.DELT_FLG,'Y',C.UPD_DT,B.CNG_OFC_TO_DT),'YYYYMMDD') CNG_OFC_TO_DT," ).append("\n"); 
		query.append("	B.RQST_CTNT," ).append("\n"); 
		query.append("	B.CRE_USR_ID," ).append("\n"); 
		query.append("	TO_CHAR(A.CRE_DT,'YYYYMMDD') CRE_DT," ).append("\n"); 
		query.append("	B.UPD_USR_ID," ).append("\n"); 
		query.append("	TO_CHAR(B.UPD_DT,'YYYYMMDD') UPD_DT," ).append("\n"); 
		query.append("	DECODE(SIGN(DECODE(C.DELT_FLG,'Y',C.UPD_DT,B.CNG_OFC_TO_DT)-SYSDATE), -1, 'Y', 'N') EXPIRE" ).append("\n"); 
		query.append("FROM COM_USER A, COM_USR_OFC_CNG B, MDM_ORGANIZATION C" ).append("\n"); 
		query.append("WHERE A.USR_ID = B.USR_ID" ).append("\n"); 
		query.append("AND B.CNG_OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("AND ('ALL' = @[usr_id] OR A.USR_ID LIKE '%'||@[usr_id]||'%' )" ).append("\n"); 
		query.append("AND ('ALL' = @[usr_nm] OR A.USR_NM LIKE '%'||@[usr_nm]||'%' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("	default_lgin_ofc," ).append("\n"); 
		query.append("	usr_id," ).append("\n"); 
		query.append("	usr_nm," ).append("\n"); 
		query.append("	usr_locl_nm,             " ).append("\n"); 
		query.append("	ofc_cd," ).append("\n"); 
		query.append("	cng_ofc_cd," ).append("\n"); 
		query.append("	rhq," ).append("\n"); 
		query.append("	cng_ofc_fm_dt," ).append("\n"); 
		query.append("	cng_ofc_to_dt," ).append("\n"); 
		query.append("	rqst_ctnt," ).append("\n"); 
		query.append("	cre_usr_id," ).append("\n"); 
		query.append("	cre_dt," ).append("\n"); 
		query.append("	upd_usr_id," ).append("\n"); 
		query.append("	upd_dt," ).append("\n"); 
		query.append("	expire," ).append("\n"); 
		query.append("	no" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("	1 no," ).append("\n"); 
		query.append("	decode(a.ofc_cd, nvl(a.lst_lgin_ofc_cd, a.ofc_cd), 1, 0) default_lgin_ofc," ).append("\n"); 
		query.append("	a.usr_id usr_id," ).append("\n"); 
		query.append("	a.usr_nm usr_nm ," ).append("\n"); 
		query.append("	a.usr_locl_nm  usr_locl_nm ," ).append("\n"); 
		query.append("	a.ofc_cd ofc_cd," ).append("\n"); 
		query.append("	a.ofc_cd cng_ofc_cd," ).append("\n"); 
		query.append("	nvl(c.AR_HD_QTR_OFC_CD, a.ofc_cd) rhq," ).append("\n"); 
		query.append("	'' cng_ofc_fm_dt," ).append("\n"); 
		query.append("	'' cng_ofc_to_dt," ).append("\n"); 
		query.append("	'' rqst_ctnt," ).append("\n"); 
		query.append("	'' cre_usr_id," ).append("\n"); 
		query.append("	'' cre_dt," ).append("\n"); 
		query.append("	'' upd_usr_id," ).append("\n"); 
		query.append("	'' upd_dt," ).append("\n"); 
		query.append("	'N' expire" ).append("\n"); 
		query.append("from COM_USER a, mdm_organization c		  " ).append("\n"); 
		query.append("where a.ofc_cd = c.ofc_cd" ).append("\n"); 
		query.append("AND ('ALL' = @[usr_id] OR a.usr_id LIKE @[usr_id]||'%' )" ).append("\n"); 
		query.append("AND ('ALL' = @[usr_nm] OR a.usr_nm LIKE @[usr_nm]||'%' )" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("SELECT 1 + (ROW_NUMBER() OVER (ORDER BY b.cng_ofc_fm_dt DESC)) no," ).append("\n"); 
		query.append("	decode(a.lst_lgin_ofc_cd, b.cng_ofc_cd, 1, 0) default_lgin_ofc," ).append("\n"); 
		query.append("	a.usr_id usr_id," ).append("\n"); 
		query.append("	a.usr_nm usr_nm," ).append("\n"); 
		query.append("	a.usr_locl_nm usr_locl_nm,                         " ).append("\n"); 
		query.append("	a.ofc_cd ofc_cd,  " ).append("\n"); 
		query.append("	b.cng_ofc_cd cng_ofc_cd," ).append("\n"); 
		query.append("	nvl(c.AR_HD_QTR_OFC_CD, b.cng_ofc_cd) rhq," ).append("\n"); 
		query.append("	TO_CHAR(b.cng_ofc_fm_dt,'YYYYMMDD') cng_ofc_fm_dt,              " ).append("\n"); 
		query.append("	TO_CHAR(DECODE(C.DELT_FLG,'Y',C.UPD_DT,B.CNG_OFC_TO_DT),'YYYYMMDD') cng_ofc_to_dt,                 " ).append("\n"); 
		query.append("	b.rqst_ctnt rqst_ctnt,                   		" ).append("\n"); 
		query.append("	b.cre_usr_id cre_usr_id,                       " ).append("\n"); 
		query.append("	TO_CHAR(a.cre_dt,'YYYYMMDD') cre_dt ,                         	" ).append("\n"); 
		query.append("	b.upd_usr_id upd_usr_id,                   " ).append("\n"); 
		query.append("	TO_CHAR(b.upd_dt,'YYYYMMDD') upd_dt," ).append("\n"); 
		query.append("	decode(sign(DECODE(C.DELT_FLG,'Y',C.UPD_DT,B.CNG_OFC_TO_DT)-sysdate), -1, 'Y', 'N') expire" ).append("\n"); 
		query.append("	from COM_USER a, com_usr_ofc_cng b, mdm_organization c			" ).append("\n"); 
		query.append("	where a.usr_id = b.usr_id						" ).append("\n"); 
		query.append("	AND b.cng_ofc_cd = c.ofc_cd" ).append("\n"); 
		query.append("	AND ('ALL' = @[usr_id] OR a.usr_id LIKE @[usr_id]||'%')" ).append("\n"); 
		query.append("	AND ('ALL' = @[usr_nm] OR a.usr_nm LIKE @[usr_nm]||'%')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by cng_ofc_cd" ).append("\n"); 

	}
}