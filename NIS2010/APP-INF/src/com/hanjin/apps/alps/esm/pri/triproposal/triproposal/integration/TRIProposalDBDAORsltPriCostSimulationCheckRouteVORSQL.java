/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TRIProposalDBDAORsltPriCostSimulationCheckRouteVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.23
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.03.23 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAORsltPriCostSimulationCheckRouteVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *   Pre CM/OP Simulation화면에서 입력한 POL,POD 가 정확한지 점사한다.
	  * </pre>
	  */
	public TRIProposalDBDAORsltPriCostSimulationCheckRouteVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAORsltPriCostSimulationCheckRouteVORSQL").append("\n"); 
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
		query.append("SELECT ORI.ROUT_PNT_LOC_CD" ).append("\n"); 
		query.append("    ,ORI.TRI_PROP_NO" ).append("\n"); 
		query.append("    ,ORI.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("    ,ORI.ROUT_PNT_SEQ" ).append("\n"); 
		query.append("    ,ORI.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("FROM (    " ).append("\n"); 
		query.append("	select ROUT_PNT_LOC_CD,TRI_PROP_NO,ORG_DEST_TP_CD,ROUT_PNT_SEQ,NVL(RCV_DE_TERM_CD,'Y') AS RCV_DE_TERM_CD" ).append("\n"); 
		query.append("	from PRI_TRI_RT_ROUT_PNT " ).append("\n"); 
		query.append("	where  TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append("	       AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("	       AND ROUT_PNT_LOC_CD = @[por_cd]" ).append("\n"); 
		query.append("	       AND  NVL(RCV_DE_TERM_CD,'Y') = @[bkg_rcv_term_cd]" ).append("\n"); 
		query.append("    ) ORI" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	select ROUT_PNT_LOC_CD,TRI_PROP_NO,ORG_DEST_TP_CD,ROUT_PNT_SEQ,NVL(RCV_DE_TERM_CD,'Y') AS RCV_DE_TERM_CD" ).append("\n"); 
		query.append("	from PRI_TRI_RT_ROUT_PNT " ).append("\n"); 
		query.append("	where  TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append("	       AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("	       AND ROUT_PNT_LOC_CD = @[del_cd]" ).append("\n"); 
		query.append("	       AND  NVL(RCV_DE_TERM_CD,'Y') = @[bkg_de_term_cd]" ).append("\n"); 
		query.append("    ) DST   " ).append("\n"); 
		query.append("WHERE ORI.TRI_PROP_NO = DST.TRI_PROP_NO     " ).append("\n"); 

	}
}