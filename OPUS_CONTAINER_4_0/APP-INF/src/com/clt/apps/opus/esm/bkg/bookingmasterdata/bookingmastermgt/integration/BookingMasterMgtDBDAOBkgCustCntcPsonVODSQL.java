/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.07 KimByungKyu
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration ;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimByungKyu
 * @see 
 * @since J2EE 1.4
 */

public class BookingMasterMgtDBDAOBkgCustCntcPsonVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingMasterMgtDBDAOBkgCustCntcPsonVO
	  * </pre>
	  */
	public BookingMasterMgtDBDAOBkgCustCntcPsonVODSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "2,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "2,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("delete from bkg_cust_cntc_pson" ).append("\n"); 
		query.append("where	cust_cnt_cd = @[cust_cnt_cd]" ).append("\n"); 
		query.append("and	cust_seq = @[cust_seq]" ).append("\n"); 
		query.append("and	cntc_pson_seq = @[cntc_pson_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration ").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOBkgCustCntcPsonVODSQL").append("\n"); 
		query.append("Developer: KimByungKyu").append("\n");
		query.append("*/").append("\n"); 
	}
}