/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OfficeManageDBDAOSearchGeneralOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeManageDBDAOSearchGeneralOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchGeneralOfficeList
	  * </pre>
	  */
	public OfficeManageDBDAOSearchGeneralOfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.integration").append("\n"); 
		query.append("FileName : OfficeManageDBDAOSearchGeneralOfficeListRSQL").append("\n"); 
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
		query.append("SELECT NVL(a.n3pty_ofc_tp_cd,'G') n3pty_ofc_tp_cd" ).append("\n"); 
		query.append("        ,NVL(a.ofc_cd,b.ofc_cd) ofc_cd" ).append("\n"); 
		query.append("        ,rhq_cd" ).append("\n"); 
		query.append("        ,n3pty_ctrl_ofc_cd" ).append("\n"); 
		query.append("        ,n3pty_ofc_cd" ).append("\n"); 
		query.append("        ,n3pty_ar_ofc_cd" ).append("\n"); 
		query.append("        ,NVL(a.delt_flg,'N') delt_flg" ).append("\n"); 
		query.append("        ,a.cre_usr_id" ).append("\n"); 
		query.append("        ,to_char(a.cre_dt,'YYYY/MM/DD') AS cre_dt" ).append("\n"); 
		query.append("        ,a.upd_usr_id" ).append("\n"); 
		query.append("        ,to_char(a.upd_dt,'YYYY/MM/DD') AS upd_dt" ).append("\n"); 
		query.append("        ,b.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("		,decode(a.ofc_cd, null, 'N', 'Y') is_save" ).append("\n"); 
		query.append("FROM tpb_hndl_ofc a, mdm_organization b" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND a.ofc_cd(+) = b.ofc_cd" ).append("\n"); 
		query.append("AND a.n3pty_ofc_tp_cd(+) = 'G' " ).append("\n"); 
		query.append("AND b.OFC_KND_CD NOT IN ('1','2')" ).append("\n"); 
		query.append("AND nvl(B.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_ofc_cd} != '') " ).append("\n"); 
		query.append("   AND b.ofc_cd LIKE @[s_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY n3pty_ofc_cd, ofc_cd asc" ).append("\n"); 

	}
}