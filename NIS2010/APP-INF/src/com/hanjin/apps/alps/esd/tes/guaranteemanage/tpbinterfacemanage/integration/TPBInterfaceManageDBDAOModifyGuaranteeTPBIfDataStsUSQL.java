/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TPBInterfaceManageDBDAOModifyGuaranteeTPBIfDataStsUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage.tpbinterfacemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TPBInterfaceManageDBDAOModifyGuaranteeTPBIfDataStsUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guarantee TPB I/F 정보 수정
	  * </pre>
	  */
	public TPBInterfaceManageDBDAOModifyGuaranteeTPBIfDataStsUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_gnte_cntr_list_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_if_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_no_if_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.guaranteemanage.tpbinterfacemanage.integration").append("\n"); 
		query.append("FileName : TPBInterfaceManageDBDAOModifyGuaranteeTPBIfDataStsUSQL").append("\n"); 
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
		query.append("UPDATE  TES_GNTE_CNTR_LIST SET" ).append("\n"); 
		query.append("        TML_IF_OFC_CD   = @[tml_if_ofc_cd]" ).append("\n"); 
		query.append("        , TML_IF_SEQ    = @[tml_if_seq]" ).append("\n"); 
		query.append("        , UPD_USR_ID    = @[upd_usr_id]" ).append("\n"); 
		query.append("        , UPD_DT        = SYSDATE" ).append("\n"); 
		query.append("		, IRR_NO_IF_FLG = @[irr_no_if_flg]" ).append("\n"); 
		query.append("WHERE   1   = 1" ).append("\n"); 
		query.append("AND     GNTE_NO = @[gnte_no]" ).append("\n"); 
		query.append("AND     TML_GNTE_CNTR_LIST_SEQ  = @[tml_gnte_cntr_list_seq]" ).append("\n"); 

	}
}