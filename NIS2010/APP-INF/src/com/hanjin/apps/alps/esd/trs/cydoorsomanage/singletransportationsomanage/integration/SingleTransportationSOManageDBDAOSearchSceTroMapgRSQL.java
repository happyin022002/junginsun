/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOSearchSceTroMapgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.16
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOSearchSceTroMapgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SO Creation 시 SCE_TRO_MAPG 테이블에 있는지 확인 로직
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOSearchSceTroMapgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trs_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rcvde_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trs_cost_dtl_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_sub_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ui_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOSearchSceTroMapgRSQL").append("\n"); 
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
		query.append("SELECT DECODE(BKG_STS_CD, 'X', 'X'," ).append("\n"); 
		query.append("DECODE( DECODE(@[bkg_rcvde_term_cd]," ).append("\n"); 
		query.append("DECODE(@[trs_bnd_cd], 'O', RCV_TERM_CD, 'I', DE_TERM_CD, @[bkg_rcvde_term_cd]), 'N', 'R') , 'N' ," ).append("\n"); 
		query.append("DECODE(@[trs_cost_dtl_mod_cd] ,'DOOR'," ).append("\n"); 
		query.append("DECODE(@[bkg_rcvde_term_cd], 'D' ," ).append("\n"); 
		query.append("DECODE(@[ui_conti_cd], 'E'," ).append("\n"); 
		query.append("DECODE(COUNT(B.COP_NO), 0, 'T', 'N'), 'M'," ).append("\n"); 
		query.append("DECODE(@[trs_bnd_cd], 'O'," ).append("\n"); 
		query.append("DECODE(COUNT(B.COP_NO), 0, 'T', 'N'), 'N'), 'N') , 'N' ), 'N') ," ).append("\n"); 
		query.append("DECODE(@[bkg_rcvde_term_cd]," ).append("\n"); 
		query.append("DECODE(@[trs_bnd_cd], 'O', RCV_TERM_CD, DE_TERM_CD), 'N', 'R') ) ) AS CONFIRM_FLG" ).append("\n"); 
		query.append("FROM   BKG_BOOKING A," ).append("\n"); 
		query.append("SCE_TRO_MAPG B" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND    B.IO_BND_CD(+) = @[trs_bnd_cd]" ).append("\n"); 
		query.append("AND    B.TRO_SEQ(+) = @[tro_seq]" ).append("\n"); 
		query.append("AND    B.TRO_SUB_SEQ(+) = @[tro_sub_seq]" ).append("\n"); 
		query.append("GROUP BY A.BKG_STS_CD, A.RCV_TERM_CD, A.DE_TERM_CD" ).append("\n"); 

	}
}