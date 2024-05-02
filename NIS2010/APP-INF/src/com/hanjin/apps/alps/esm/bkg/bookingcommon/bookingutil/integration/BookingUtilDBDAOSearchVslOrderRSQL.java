/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOSearchVslOrderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.21
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.03.21 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchVslOrderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ocean route의 vvd 들이 etd, eta의 순서가 맞는지 확인하여 true/false로 return한다.
	  * </pre>
	  */
	public BookingUtilDBDAOSearchVslOrderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("befClptIndSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curVvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curPolCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curClptIndSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("befPodCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("befVvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchVslOrderRSQL").append("\n"); 
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
		query.append("--조회 건수가 없으면 error" ).append("\n"); 
		query.append("select count(1) CNT" ).append("\n"); 
		query.append("from vsk_vsl_port_skd vvd1" ).append("\n"); 
		query.append(", vsk_vsl_port_skd vvd2" ).append("\n"); 
		query.append("where 1 = 1" ).append("\n"); 
		query.append("and vvd1.vsl_cd       = substr(@[befVvd], 1, 4)" ).append("\n"); 
		query.append("and vvd1.skd_voy_no   = substr(@[befVvd], 5, 4)" ).append("\n"); 
		query.append("and vvd1.skd_dir_cd   = substr(@[befVvd], 9, 1)" ).append("\n"); 
		query.append("and vvd1.VPS_PORT_CD  = @[befPodCd]" ).append("\n"); 
		query.append("and vvd1.clpt_ind_seq = NVL(@[befClptIndSeq], 1)" ).append("\n"); 
		query.append("and vvd2.vsl_cd       = substr(@[curVvd], 1, 4)" ).append("\n"); 
		query.append("and vvd2.skd_voy_no   = substr(@[curVvd], 5, 4)" ).append("\n"); 
		query.append("and vvd2.skd_dir_cd   = substr(@[curVvd], 9, 1)" ).append("\n"); 
		query.append("and vvd2.VPS_PORT_CD  = @[curPolCd]" ).append("\n"); 
		query.append("and vvd2.clpt_ind_seq = NVL(@[curClptIndSeq], 1)" ).append("\n"); 
		query.append("and vvd1.vps_etb_dt   < vvd2.vps_etd_dt" ).append("\n"); 

	}
}