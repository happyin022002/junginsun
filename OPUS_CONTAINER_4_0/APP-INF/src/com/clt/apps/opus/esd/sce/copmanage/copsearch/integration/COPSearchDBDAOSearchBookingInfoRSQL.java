/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COPSearchDBDAOSearchBookingInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.10.01 오현경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Oh hyun-kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPSearchDBDAOSearchBookingInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBookingInfo
	  * </pre>
	  */
	public COPSearchDBDAOSearchBookingInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copmanage.copsearch.integration").append("\n"); 
		query.append("FileName : COPSearchDBDAOSearchBookingInfoRSQL").append("\n"); 
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
		query.append("SELECT a.*" ).append("\n"); 
		query.append(", TO_CHAR(d.snd_dt, 'YYYYMMDDHH24MISS') AS dbl_iss_dt" ).append("\n"); 
		query.append(", TO_CHAR(e.snd_dt, 'YYYYMMDDHH24MISS') AS ani_iss_dt" ).append("\n"); 
		query.append(", TO_CHAR(b.cre_dt, 'YYYYMMDDHH24MISS') AS ca_iss_dt" ).append("\n"); 
		query.append(", c.iss_dt AS niv_iss_dt" ).append("\n"); 
		query.append("FROM bkg_booking a" ).append("\n"); 
		query.append(",(SELECT bkg_no, MAX(cre_dt) AS cre_dt" ).append("\n"); 
		query.append("FROM bkg_correction b" ).append("\n"); 
		query.append("WHERE bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("GROUP BY bkg_no" ).append("\n"); 
		query.append(") b" ).append("\n"); 
		query.append(", (SELECT D.BKG_NO, A.ISS_DT" ).append("\n"); 
		query.append("FROM INV_AR_ISS A" ).append("\n"); 
		query.append(", INV_AR_ISS_DTL B" ).append("\n"); 
		query.append(", INV_AR_MN D" ).append("\n"); 
		query.append("WHERE 1 =1" ).append("\n"); 
		query.append("AND A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("AND B.AR_IF_NO = D.AR_IF_NO" ).append("\n"); 
		query.append("AND D.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND INV_SEQ=1" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") c" ).append("\n"); 
		query.append(", (SELECT bkg_no, MAX(snd_dt) AS snd_dt" ).append("\n"); 
		query.append("FROM bkg_ntc_his" ).append("\n"); 
		query.append("WHERE bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("AND ntc_knd_cd = 'BL'" ).append("\n"); 
		query.append("GROUP BY bkg_no" ).append("\n"); 
		query.append(") d" ).append("\n"); 
		query.append(", (SELECT bkg_no, MAX(snd_dt) AS snd_dt" ).append("\n"); 
		query.append("FROM bkg_ntc_his" ).append("\n"); 
		query.append("WHERE bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("AND ntc_knd_cd = 'AN'" ).append("\n"); 
		query.append("GROUP BY bkg_no" ).append("\n"); 
		query.append(") e" ).append("\n"); 
		query.append("WHERE a.bkg_no = b.bkg_no(+)" ).append("\n"); 
		query.append("AND a.bkg_no = c.bkg_no (+)" ).append("\n"); 
		query.append("AND a.bkg_no = d.bkg_no (+)" ).append("\n"); 
		query.append("AND a.bkg_no = e.bkg_no (+)" ).append("\n"); 
		query.append("AND a.bkg_no = @[bkg_no]" ).append("\n"); 

	}
}