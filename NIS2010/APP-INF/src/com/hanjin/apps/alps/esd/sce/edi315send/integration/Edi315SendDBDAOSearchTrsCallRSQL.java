/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOSearchTrsCallRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.02.23 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchTrsCallRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for SearchTrsCall
	  * </pre>
	  */
	public Edi315SendDBDAOSearchTrsCallRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cost_act_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchTrsCallRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO,BL_NO,CNTR_NO,COP_NO,EVENT_YARD" ).append("\n"); 
		query.append(",to_char(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', sysdate, substr(EVENT_YARD, 1, 5)),'yyyymmddhh24miss') event_dt" ).append("\n"); 
		query.append(",'COP'call_From" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("select H.BKG_NO" ).append("\n"); 
		query.append(", H.CNTR_NO" ).append("\n"); 
		query.append(", H.COP_NO" ).append("\n"); 
		query.append(", DECODE(SUBSTR(COST_ACT_GRP_CD,3,1),'T',N1ST_NOD_CD, N2ND_NOD_CD) EVENT_YARD" ).append("\n"); 
		query.append(", B.BL_NO" ).append("\n"); 
		query.append("from sce_pln_so_list S, SCE_COP_HDR H, bkg_booking b" ).append("\n"); 
		query.append("where S.cop_no = @[e_cop_no]" ).append("\n"); 
		query.append("and S.COST_ACT_GRP_SEQ = @[e_cost_act_grp_seq]" ).append("\n"); 
		query.append("and B.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("and S.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("and S.COST_ACT_GRP_CD like 'ID%T%'" ).append("\n"); 
		query.append("AND S.COP_NO = H.COP_NO" ).append("\n"); 
		query.append(")V" ).append("\n"); 

	}
}