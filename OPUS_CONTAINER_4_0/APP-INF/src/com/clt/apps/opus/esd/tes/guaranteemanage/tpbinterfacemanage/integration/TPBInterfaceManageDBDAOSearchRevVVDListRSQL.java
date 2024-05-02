/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TPBInterfaceManageDBDAOSearchRevVVDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.02.04 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.guaranteemanage.tpbinterfacemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TPBInterfaceManageDBDAOSearchRevVVDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TPB I/F Financial VVD 조회
	  * </pre>
	  */
	public TPBInterfaceManageDBDAOSearchRevVVDListRSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.guaranteemanage.tpbinterfacemanage.integration").append("\n"); 
		query.append("FileName : TPBInterfaceManageDBDAOSearchRevVVDListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("GL.GNTE_NO" ).append("\n"); 
		query.append(", GL.TML_GNTE_CNTR_LIST_SEQ" ).append("\n"); 
		query.append(", GL.CNTR_NO" ).append("\n"); 
		query.append(", GL.BKG_NO" ).append("\n"); 
		query.append(", CASE WHEN GL.BKG_NO IS NOT NULL AND TES_BKG_REV_VVD_FNC(GL.BKG_NO) IS NOT NULL" ).append("\n"); 
		query.append("THEN TES_BKG_REV_VVD_FNC(GL.BKG_NO)" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END REV_VVD" ).append("\n"); 
		query.append("FROM	TES_GNTE_HDR GH" ).append("\n"); 
		query.append(", TES_GNTE_CNTR_LIST GL" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND		GH.GNTE_NO	= GL.GNTE_NO" ).append("\n"); 
		query.append("AND		NVL(GH.DMY_FLG, 'N')	<> 'Y'" ).append("\n"); 
		query.append("AND		NVL(GH.DELT_FLG, 'N')	<> 'Y'" ).append("\n"); 
		query.append("AND		GL.BKG_NO IS NOT NULL" ).append("\n"); 
		query.append("AND		GH.GNTE_NO	= @[gnte_no]" ).append("\n"); 
		query.append("AND		GL.CNTR_NO	= @[cntr_no]" ).append("\n"); 
		query.append("AND		GL.BKG_NO	= @[bkg_no]" ).append("\n"); 
		query.append("AND     GL.TML_GNTE_CNTR_LIST_SEQ   = @[tml_gnte_cntr_list_seq]" ).append("\n"); 

	}
}