/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailBillingCommonDBDAOsearchRailBillingAckCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.24
*@LastModifier : 박연진
*@LastVersion : 1.0
* 2009.10.24 박연진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.railbillingcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Yeon-Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingCommonDBDAOsearchRailBillingAckCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Potal Main Rail Bill Ack Count 조회  화면에 대한 조회
	  * </pre>
	  */
	public RailBillingCommonDBDAOsearchRailBillingAckCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.railbilling.railbillingcommon.integration").append("\n"); 
		query.append("FileName : RailBillingCommonDBDAOsearchRailBillingAckCountRSQL").append("\n"); 
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
		query.append("SELECT /*+ leading(a b c)*/" ).append("\n"); 
		query.append("count(*) ack_cnt" ).append("\n"); 
		query.append("FROM trs_trsp_rail_bil_ord a" ).append("\n"); 
		query.append(",trs_trsp_rail_bil_vndr_set b" ).append("\n"); 
		query.append(",trs_trsp_edi_rail_ord c" ).append("\n"); 
		query.append("WHERE a.prov_vndr_seq = @[vndr_seq]" ).append("\n"); 
		query.append("AND NVL(a.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("AND a.cre_dt BETWEEN TO_DATE(TO_CHAR(SYSDATE - 7, 'yyyymmdd') || '000000', 'yyyymmddhh24miss')" ).append("\n"); 
		query.append("AND TO_DATE(TO_CHAR(SYSDATE, 'yyyymmdd') || '235959', 'yyyymmddhh24miss')" ).append("\n"); 
		query.append("AND b.trsp_so_ofc_cty_cd = a.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("AND b.trsp_so_seq = a.trsp_so_seq" ).append("\n"); 
		query.append("AND c.trsp_so_ofc_cty_cd = b.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("AND c.trsp_so_seq = b.trsp_so_seq" ).append("\n"); 
		query.append("AND trim(c.vndr_seq) = b.vndr_seq" ).append("\n"); 
		query.append("AND c.bil_iss_sts_cd = 'I'" ).append("\n"); 
		query.append("AND trim(c.bil_edi_rcv_rslt_cd) = 'A'" ).append("\n"); 
		query.append("AND NVL(c.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("AND c.bil_edi_rcv_rslt_dt BETWEEN TO_DATE(TO_CHAR(SYSDATE - 7, 'yyyymmdd') || '000000', 'yyyymmddhh24miss')" ).append("\n"); 
		query.append("AND TO_DATE(TO_CHAR(SYSDATE, 'yyyymmdd') || '235959', 'yyyymmddhh24miss')" ).append("\n"); 

	}
}