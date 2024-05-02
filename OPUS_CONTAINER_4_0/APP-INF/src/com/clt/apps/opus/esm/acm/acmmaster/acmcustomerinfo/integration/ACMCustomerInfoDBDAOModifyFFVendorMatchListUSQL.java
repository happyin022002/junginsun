/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCustomerInfoDBDAOModifyFFVendorMatchListUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.07
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.07 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmmaster.acmcustomerinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMCustomerInfoDBDAOModifyFFVendorMatchListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public ACMCustomerInfoDBDAOModifyFFVendorMatchListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_ff_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ff_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmmaster.acmcustomerinfo.integration").append("\n");
		query.append("FileName : ACMCustomerInfoDBDAOModifyFFVendorMatchListUSQL").append("\n");
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
		query.append("UPDATE ACM_FF_VNDR_MTCH" ).append("\n");
		query.append("   SET FF_CNT_CD = SUBSTR(@[ff_cnt_seq], 1, 2)," ).append("\n");
		query.append("       FF_SEQ = TO_NUMBER(SUBSTR(@[ff_cnt_seq], 3))," ).append("\n");
		query.append("       VNDR_CNT_CD = @[vndr_cnt_cd]," ).append("\n");
		query.append("       VNDR_SEQ = @[vndr_seq]," ).append("\n");
		query.append("       UPD_USR_ID = @[usr_id]," ).append("\n");
		query.append("       UPD_DT = SYSDATE" ).append("\n");
		query.append(" WHERE FF_CNT_CD = @[ff_cnt_cd]" ).append("\n");
		query.append("   AND FF_SEQ = @[org_ff_seq]" ).append("\n");
		query.append("   AND VNDR_CNT_CD = @[org_vndr_cnt_cd]" ).append("\n");
		query.append("   AND VNDR_SEQ = @[org_vndr_seq]" ).append("\n");

	}
}