/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOcheckIfPortRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.29
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOcheckIfPortRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOcheckIfPortRateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dc_rto_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_blk_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOcheckIfPortRateRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("DECODE(CNTR_BLK_DIV_CD,'C','CNTR','BULK') AS CNTR_BLK_DIV_CD, " ).append("\n"); 
		query.append("PORT_CD, " ).append("\n"); 
		query.append("DECODE(IO_BND_CD,'I','II','OO') AS IO_BND_CD, " ).append("\n"); 
		query.append("DECODE(DC_RTO_NO,'0','0','1','20','7','30','2','50','8','70','3','80','4','100') AS DC_RTO_NO" ).append("\n"); 
		query.append("FROM BKG_KR_WHF_PORT_RT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CNTR_BLK_DIV_CD = @[cntr_blk_div_cd]" ).append("\n"); 
		query.append("AND PORT_CD         = @[port_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD       = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND DC_RTO_NO       = @[dc_rto_no]" ).append("\n"); 
		query.append("AND ( EFF_FM_DT BETWEEN TO_DATE(@[eff_fm_dt],'YYYY-MM-DD') AND TO_DATE(@[eff_to_dt],'YYYY-MM-DD')+0.99999    " ).append("\n"); 
		query.append("OR   EFF_TO_DT BETWEEN TO_DATE(@[eff_fm_dt],'YYYY-MM-DD') AND TO_DATE(@[eff_to_dt],'YYYY-MM-DD')+0.99999)" ).append("\n"); 

	}
}