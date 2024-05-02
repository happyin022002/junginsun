/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferOrderIssueDBDAOBkgTroActCustVODSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.05.19 이남경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Nam Kyung
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class TransferOrderIssueDBDAOBkgTroActCustVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * delete sql
	  * </pre>
	  */
	public TransferOrderIssueDBDAOBkgTroActCustVODSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "2,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_act_cust_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("delete from bkg_tro_act_cust" ).append("\n");
		query.append("where	tro_act_cust_knd_cd = @[tro_act_cust_knd_cd]" ).append("\n");
		query.append("and	tro_vndr_seq = @[tro_vndr_seq]" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n");
		query.append("FileName : TransferOrderIssueDBDAOBkgTroActCustVODSQL").append("\n");
		query.append("*/").append("\n");
	}
}