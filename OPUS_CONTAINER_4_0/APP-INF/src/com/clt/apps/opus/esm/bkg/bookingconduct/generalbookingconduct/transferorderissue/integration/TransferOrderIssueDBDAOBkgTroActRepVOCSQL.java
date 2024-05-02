/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferOrderIssueDBDAOBkgTroActRepVOCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.05.13 이남경
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

public class TransferOrderIssueDBDAOBkgTroActRepVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ESM_BKG_0905 t2 master create
	  * </pre>
	  */
	public TransferOrderIssueDBDAOBkgTroActRepVOCSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_act_rep_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("insert into bkg_tro_act_rep (" ).append("\n");
		query.append("ofc_cd," ).append("\n");
		query.append("tro_act_rep_seq," ).append("\n");
		query.append("tro_act_rep_nm," ).append("\n");
		query.append("delt_flg," ).append("\n");
		query.append("cre_usr_id," ).append("\n");
		query.append("cre_dt," ).append("\n");
		query.append("upd_usr_id," ).append("\n");
		query.append("upd_dt" ).append("\n");
		query.append(") values(" ).append("\n");
		query.append("@[ofc_cd]," ).append("\n");
		query.append("nvl((select /*+ index_desc(bkg_tro_act_rep XPKBKG_TRO_ACT_REP)  */" ).append("\n");
		query.append("tro_act_rep_seq" ).append("\n");
		query.append("from bkg_tro_act_rep" ).append("\n");
		query.append("where ofc_cd = @[ofc_cd]" ).append("\n");
		query.append("and rownum = 1 ),0)+1," ).append("\n");
		query.append("@[tro_act_rep_nm]," ).append("\n");
		query.append("'N'," ).append("\n");
		query.append("@[cre_usr_id]," ).append("\n");
		query.append("sysdate," ).append("\n");
		query.append("@[cre_usr_id]," ).append("\n");
		query.append("sysdate" ).append("\n");
		query.append(")" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n");
		query.append("FileName : TransferOrderIssueDBDAOBkgTroActRepVOCSQL").append("\n");
		query.append("*/").append("\n");
	}
}