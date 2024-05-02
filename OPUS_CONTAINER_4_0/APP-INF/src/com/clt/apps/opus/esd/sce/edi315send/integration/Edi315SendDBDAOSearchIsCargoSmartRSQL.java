/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOSearchIsCargoSmartRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.03.03 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchIsCargoSmartRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for search is cargo smart
	  * </pre>
	  */
	public Edi315SendDBDAOSearchIsCargoSmartRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_edi_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchIsCargoSmartRSQL").append("\n"); 
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
		query.append("SELECT -- into v_blocked" ).append("\n"); 
		query.append("CASE WHEN CNT_EDI >= 1 AND CNT_BKG >= 1" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END V_BLOCKED" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("--Receiver ID 가 CARGOSMART 일 때." ).append("\n"); 
		query.append("--EDI_GRP_CD USA00269, USA00085, USA00248, USA00179 ,COM01824 는 제외." ).append("\n"); 
		query.append("-- 'USA00292' 2009.10.20 추가" ).append("\n"); 
		query.append("-- 'COM01824'  2009.11.10 추가" ).append("\n"); 
		query.append("-- CHM-200901586  'ASA00444' 2009.11.18 추가" ).append("\n"); 
		query.append("-- CHM-201002309  'USA00298', 'USA00313'   2010.01.22 추가" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT_EDI" ).append("\n"); 
		query.append("FROM   edi_group" ).append("\n"); 
		query.append("WHERE  edi_grp_cd       = @[e_edi_grp_cd]" ).append("\n"); 
		query.append("AND    cust_trd_prnr_id = 'CARGOSMART'" ).append("\n"); 
		query.append("AND    edi_grp_cd NOT IN ('USA00269', 'USA00085', 'USA00248', 'USA00179', 'USA00292','COM01824','ASA00444','USA00298', 'USA00313')" ).append("\n"); 
		query.append("AND    NVL(delt_flg,'N') = 'N'" ).append("\n"); 
		query.append(")EDI," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select COUNT(*) CNT_BKG" ).append("\n"); 
		query.append("from   bkg_booking B" ).append("\n"); 
		query.append("WHERE  b.bkg_no          = @[e_bkg_no]" ).append("\n"); 
		query.append("AND    b.XTER_BKG_RQST_CD <> 'CSM' -- 항상 'NIS'인듯 함." ).append("\n"); 
		query.append("AND    b.XTER_SI_CD <> 'CSM'" ).append("\n"); 
		query.append(")BKG" ).append("\n"); 

	}
}