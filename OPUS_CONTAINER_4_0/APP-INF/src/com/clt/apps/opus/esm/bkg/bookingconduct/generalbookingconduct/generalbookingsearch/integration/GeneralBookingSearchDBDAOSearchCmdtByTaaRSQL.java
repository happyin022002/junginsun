/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchCmdtByTaaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.18
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.05.18 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchCmdtByTaaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TAA 계약상의 Commodity 정보를 조회한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchCmdtByTaaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchCmdtByTaaRSQL").append("\n"); 
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
		query.append("select distinct cmdt.cmdt_cd, cmdt.cmdt_nm cmdt_nm, taa.SVC_SCP_CD, cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("from PRI_TRI_MN main, mdm_commodity cmdt, pri_taa_tri_list list, pri_taa_mn taa" ).append("\n"); 
		query.append("where list.taa_prop_no     = taa.taa_prop_no" ).append("\n"); 
		query.append("and list.amdt_seq        = taa.amdt_seq" ).append("\n"); 
		query.append("and main.tri_prop_no     = list.tri_prop_no" ).append("\n"); 
		query.append("and list.taa_prop_no     = @[prop_no]" ).append("\n"); 
		query.append("and list.amdt_seq        = @[amdt_seq]" ).append("\n"); 
		query.append("and taa.svc_scp_cd       = @[svc_scp_cd]" ).append("\n"); 
		query.append("and main.cmdt_cd         = cmdt.cmdt_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("and cmdt.cmdt_cd    like @[cmdt_cd]||'%' --입력했을 때만" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cmdt_nm} != '')" ).append("\n"); 
		query.append("and cmdt.cmdt_nm    like @[cmdt_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}