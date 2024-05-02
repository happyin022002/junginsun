/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGExternalFinderDBDAOcheckBKGRSQL.java
*@FileTitle : a
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.01 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HyunUk Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGExternalFinderDBDAOCheckBKGVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking 정보 조회
	  * </pre>
	  */
	public SCGExternalFinderDBDAOCheckBKGVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no_split",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT" ).append("\n"); 
		query.append("bk.split_flg" ).append("\n"); 
		query.append(",	bk.bkg_no" ).append("\n"); 
		query.append(",	bk.bkg_no_split" ).append("\n"); 
		query.append(",	bk.bl_no" ).append("\n"); 
		query.append(",	bk.por_cd" ).append("\n"); 
		query.append(",	bk.pol_cd" ).append("\n"); 
		query.append(",	bk.pod_cd" ).append("\n"); 
		query.append(",	bk.del_cd" ).append("\n"); 
		query.append(",   sh.cust_nm s_cust_nm" ).append("\n"); 
		query.append(",   ff.cust_nm f_cust_nm" ).append("\n"); 
		query.append(",   cn.cust_nm c_cust_nm" ).append("\n"); 
		query.append("FROM bkg_booking  bk" ).append("\n"); 
		query.append(", bkg_customer sh" ).append("\n"); 
		query.append(", bkg_customer ff" ).append("\n"); 
		query.append(", bkg_customer cn" ).append("\n"); 
		query.append("WHERE bk.bkg_no       = @[bkg_no]" ).append("\n"); 
		query.append("AND	bk.bkg_no_split   = DECODE(NVL(@[bkg_no_split],''),'','  ')" ).append("\n"); 
		query.append("AND bk.bkg_no         = sh.bkg_no" ).append("\n"); 
		query.append("AND bk.bkg_no_split   = sh.bkg_no_split" ).append("\n"); 
		query.append("AND sh.bkg_cust_tp_cd = 'S'" ).append("\n"); 
		query.append("AND bk.bkg_no         = ff.bkg_no" ).append("\n"); 
		query.append("AND bk.bkg_no_split   = ff.bkg_no_split" ).append("\n"); 
		query.append("AND ff.bkg_cust_tp_cd = 'F'" ).append("\n"); 
		query.append("AND bk.bkg_no         = cn.bkg_no" ).append("\n"); 
		query.append("AND bk.bkg_no_split   = cn.bkg_no_split" ).append("\n"); 
		query.append("AND cn.bkg_cust_tp_cd = 'C'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.integration").append("\n"); 
		query.append("FileName : SCGExternalFinderDBDAOcheckBKGRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}