/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortRestrictionDBDAOgetImdgPortRstrDtlForKeyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.04 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortRestrictionDBDAOgetImdgPortRstrDtlForKeyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public PortRestrictionDBDAOgetImdgPortRstrDtlForKeyRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "2,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_port_rstr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("port_cd" ).append("\n"); 
		query.append(",	imdg_port_rstr_seq" ).append("\n"); 
		query.append(",	port_prohi_tp_cd" ).append("\n"); 
		query.append(",	imdg_cmptn_auth_cd" ).append("\n"); 
		query.append(",	ton_ovr_vol_qty" ).append("\n"); 
		query.append(",	nd_tm_hrs" ).append("\n"); 
		query.append(",	tml_max_qty" ).append("\n"); 
		query.append(",	obrd_max_qty" ).append("\n"); 
		query.append(",	one_tm_hndl_max_qty" ).append("\n"); 
		query.append(",	dys_sto_flg" ).append("\n"); 
		query.append(",	sto_dys" ).append("\n"); 
		query.append(",	prohi_desc" ).append("\n"); 
		query.append(",	txt_desc" ).append("\n"); 
		query.append(",	cre_usr_id" ).append("\n"); 
		query.append(",	cre_dt" ).append("\n"); 
		query.append(",	upd_usr_id" ).append("\n"); 
		query.append(",	upd_dt" ).append("\n"); 
		query.append("FROM scg_imdg_port_rstr_dtl" ).append("\n"); 
		query.append("WHERE	port_cd = @[port_cd]" ).append("\n"); 
		query.append("AND	imdg_port_rstr_seq = @[imdg_port_rstr_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.integration ").append("\n"); 
		query.append("FileName : PortRestrictionDBDAOgetImdgPortRstrDtlForKeyRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}